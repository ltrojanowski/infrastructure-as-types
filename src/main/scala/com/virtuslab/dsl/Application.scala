package com.virtuslab.dsl

import java.net.URL

import cats.Show
import cats.data.NonEmptyList
import cats.syntax.option._
import cats.syntax.show._

sealed trait PingAction
case class HttpPing(url: URL) extends PingAction
case class TCPPing(port: Int) extends PingAction

sealed trait HealthCheckAction
case class HttpHealthCheck(url: URL) extends HealthCheckAction
case class TCPHealthCheck(port: Int) extends HealthCheckAction

case class Configuration(
    name: String,
    namespace: Namespace,
    labels: Set[Label],
    data: Map[String, String])
  extends Resource
  with Namespaced
  with Labeled {
  def labeled(ls: Label*): Configuration = {
    copy(labels = labels ++ ls)
  }
}

object Configuration {
  def apply(name: String, data: Map[String, String])(implicit ns: Namespace): Configuration = {
    Configuration(name, ns, Set(NameLabel(name)), data)
  }
}

object Application {

  case class Port(number: Int, name: Option[String] = None)
  object Port {
    implicit val show: Show[Port] = Show.show { port =>
      s"Port(number=${port.number}, name=${port.name}"
    }
  }

  case class EnvironmentVariable(key: String, value: String)

  def apply(
      name: String,
      image: String,
      command: List[String] = Nil,
      args: List[String] = Nil,
      configurations: List[Configuration] = Nil,
      ports: List[Application.Port] = Nil,
      envs: List[Application.EnvironmentVariable] = Nil,
      ping: Option[HttpPing] = None,
      healthCheck: Option[HttpHealthCheck] = None
    )(implicit
      ns: Namespace
    ): Application = {
    Application(
      name = name,
      image = image,
      namespace = ns,
      labels = Set(NameLabel(name)),
      command = command,
      args = args,
      configurations = configurations,
      ports = ports,
      envs = envs,
      ping = ping,
      healthCheck = healthCheck
    )
  }
}

case class Application(
    name: String,
    namespace: Namespace,
    labels: Set[Label],
    image: String,
    command: List[String],
    args: List[String],
    configurations: List[Configuration],
    ports: List[Application.Port],
    envs: List[Application.EnvironmentVariable],
    ping: Option[HttpPing],
    healthCheck: Option[HttpHealthCheck])
  extends Resource
  with Namespaced
  with Labeled {

  protected def addPort(port: Application.Port): Application = {
    ports
      .find(_ == port)
      .fold {
        copy(ports = port :: ports)
      } { port =>
        throw new IllegalStateException(
          s"Port ${port.show} is already defined."
        )
      }
  }

  def listensOn(number: Int): Application = {
    addPort(Application.Port(number))
  }

  def listensOn(number: Int, name: String): Application = {
    addPort(Application.Port(number, name.some))
  }

  def withConfiguration(configuration: Configuration): Application = {
    copy(configurations = configuration :: configurations)
  }

  def labeled(ls: Label*): Application = {
    copy(labels = labels ++ ls)
  }
}
