package com.virtuslab.dsl

import com.virtuslab.interpreter.{ Context, Interpreter }

import scala.collection.mutable

case class NamespaceBuilder[Ctx <: Context](namespace: Namespace[Ctx], systemBuilder: SystemBuilder[Ctx]) {
  private[this] val connections: mutable.Set[Definition[Ctx, Connection]] = mutable.Set.empty
  private[this] val applications: mutable.Set[Definition[Ctx, Application]] = mutable.Set.empty

  def references(rs: Labeled*): SystemBuilder[Ctx] = systemBuilder.references(rs: _*)

  def applications(apps: Application*)(implicit ctx: Ctx, ev: Interpreter[Ctx, Application]): NamespaceBuilder[Ctx] = {
    references(apps: _*)
    applications ++= apps.map(Definition(_, this.namespace))
    this
  }

  def connections(conns: Connection*)(implicit ctx: Ctx, ev: Interpreter[Ctx, Connection]): NamespaceBuilder[Ctx] = {
    references(conns: _*)
    val ds = conns.map(Definition(_, this.namespace))
    connections ++= ds
    this
  }

  def collect(): (Set[Definition[Ctx, Application]], Set[Definition[Ctx, Connection]]) = (applications.toSet, connections.toSet)

  def build()(implicit ctx: Ctx, ev: Interpreter[Ctx, Namespace[Ctx]]): Namespace[Ctx] = {
    val (as, cs) = collect()
    val members: Set[Definition[Ctx, Any]] = (as ++ cs).asInstanceOf[Set[Definition[Ctx, Any]]]

    val ns: Namespace[Ctx] = Namespace(namespace.labels, members)
    systemBuilder.namespaces(ns)
    ns
  }

  def name: String = namespace.name

  // TODO: extract to common place for implicits
  implicit class ApplicationConnectionOps(app: Application) {
    def communicatesWith(other: Application): Connection = {
      communicatesWith(
        SelectedApplications(
          other,
          Protocols.Any
        )
      )
    }

    def communicatesWith(other: Namespace[Ctx]): Connection = {
      communicatesWith(
        SelectedNamespaces(
          other,
          Protocols.Any
        )
      )
    }

    def communicatesWith(other: Selector): Connection = {
      Connection(
        resourceSelector = SelectedApplications(app, Protocols.Any),
        ingress = other,
        egress = SelectedApplications(app, Protocols.Any)
      )
    }
  }
}

final case class Namespace[Ctx <: Context] private[dsl] (labels: Labels, members: Set[Definition[Ctx, Any]]) extends Labeled {
  def inNamespace(
      f: NamespaceBuilder[Ctx] => NamespaceBuilder[Ctx]
    )(implicit
      systemBuilder: SystemBuilder[Ctx],
      ctx: Ctx,
      ev: Interpreter[Ctx, Namespace[Ctx]]
    ): Namespace[Ctx] = f(builder).build()
  def builder(implicit systemBuilder: SystemBuilder[Ctx]): NamespaceBuilder[Ctx] = NamespaceBuilder(this, systemBuilder)
}

object Namespace {
  def apply[Ctx <: Context](name: String)(implicit builder: SystemBuilder[Ctx], ctx: Ctx): Namespace[Ctx] = {
    apply(Labels(Name(name)))
  }

  def apply[Ctx <: Context](labels: Labels)(implicit builder: SystemBuilder[Ctx], ctx: Ctx): Namespace[Ctx] = {
    val ns: Namespace[Ctx] = Namespace(labels, Set())
    builder.references(ns)
    ns
  }
}
