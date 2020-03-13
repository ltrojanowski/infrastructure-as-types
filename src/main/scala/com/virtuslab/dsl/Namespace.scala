package com.virtuslab.dsl

import com.virtuslab.dsl.Application.{ ApplicationReference, DefinedApplication }
import com.virtuslab.dsl.Namespace.{ DefinedNamespace, NamespaceReference }
import scala.collection.mutable

trait Namespaced {
  def namespace: Namespace
}

case class NamespaceBuilder(namespace: Namespace, systemBuilder: SystemBuilder) {
  private val connections: mutable.Set[Connection[_, _, _]] = mutable.Set.empty
  private val applications: mutable.Set[Application] = mutable.Set.empty

  def references(rs: ResourceReference): SystemBuilder = systemBuilder.references(rs)

  def applications(defined: Application*): NamespaceBuilder = {
    systemBuilder.references(defined: _*)
    applications ++= defined
    this
  }

  def connections(defined: Connection[_, _, _]*): NamespaceBuilder = {
    // we don't have a ConnectionReference, so we don't add it to the SystemBuilder
    connections ++= defined
    this
  }

  def collect(): (Set[Application], Set[Connection[_, _, _]]) = (applications.toSet, connections.toSet)

  def build(): DefinedNamespace = {
    val (as, cs) = collect()
    val members: Set[Namespaced] = as.map {
      case a: ApplicationReference => a.define(this)
      case a: DefinedApplication   => a
    } ++ cs

    DefinedNamespace(namespace.name, namespace.labels, members)
  }

  // TODO: extract to common place for implicits
  implicit class ApplicationConnectionOps(app: Application) {
    def communicatesWith(other: Application)(implicit builder: NamespaceBuilder): Connection[_, _, _] = {
      communicatesWith(ApplicationSelector(other))
    }

    def communicatesWith(other: Namespace)(implicit builder: NamespaceBuilder): Connection[_, _, _] = {
      communicatesWith(NamespaceSelector(other))
    }

    def communicatesWith[S: Selectable](other: ApplicationSelector[S])(implicit builder: NamespaceBuilder): Connection[_, _, _] = {
      val connection = Connection(
        resourceSelector = ApplicationSelector(app),
        ingress = other,
        egress = ApplicationSelector(app)
      )

      connections += connection
      connection
    }

    def communicatesWith[S: Selectable](other: NamespaceSelector[S])(implicit builder: NamespaceBuilder): Connection[_, _, _] = {
      val connection = Connection(
        resourceSelector = ApplicationSelector(app),
        ingress = other,
        egress = ApplicationSelector(app)
      )

      connections += connection
      connection
    }
  }

}

trait Namespace extends ResourceReference

object Namespace {
  final case class NamespaceReference protected (name: String, labels: Set[Label]) extends Namespace {
    def inNamespace(f: NamespaceBuilder => NamespaceBuilder)(implicit systemBuilder: SystemBuilder): DefinedNamespace = f(builder).build()
    def builder(implicit systemBuilder: SystemBuilder): NamespaceBuilder = NamespaceBuilder(this, systemBuilder)
  }

  final case class DefinedNamespace protected (
      name: String,
      labels: Set[Label],
      members: Set[Namespaced])
    extends Namespace

  def ref(name: String, labels: Label*): NamespaceReference = {
    NamespaceReference(name, Set(NameLabel(name)) ++ labels)
  }

  def apply(name: String, labels: Label*)(implicit builder: SystemBuilder): NamespaceReference = {
    val ns = NamespaceReference(name, Set(NameLabel(name)))
    builder.references(ns)
    ns
  }
}
