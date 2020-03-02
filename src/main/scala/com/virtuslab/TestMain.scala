package com.virtuslab

import com.virtuslab.dsl.{Configuration, HttpApplication, Namespace, System, SystemInterpreter}
import play.api.libs.json.Format
import skuber.apps.v1.Deployment
import skuber.{K8SRequestContext, ObjectResource, ResourceDefinition}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object TestMain extends DSLMain with App {

  def deploy(): Unit = {
    import skuber.json.format._

    val namespace = Namespace("test")

    val configuration = Configuration(
      name = "app",
      namespace = namespace,
      data = Map(
        "config.yaml" ->
          """
            |listen: :8080
            |logRequests: true
            |connectors:
            |- type: file
            |  uri: file:///opt/test.txt
            |  pathPrefix: /health
            |""".stripMargin,
        "test.txt" ->
          """
            |I'm testy tester, being tested ;-)
            |""".stripMargin
      )
    )

    // Populate the namespace
    val app = HttpApplication(
      name = "app",
      namespace = namespace,
      image = "quay.io/virtuslab/cloud-file-server:v0.0.6",
      command = List("cloud-file-server"),
      args = List("--config", "/opt/config.yaml"),
      configurations = List(configuration)
    ).listensOn(8080)

    val system = System("test")
      .addApplication(app)
      .addConfiguration(configuration)

    import skuber._
    val systemInterpreter = SystemInterpreter.of(system)
    systemInterpreter(system).foreach {

      case namespace: Namespace =>
        val createNamespace = createOrUpdate(client, namespace)
        val ns = Await.result(createNamespace, 1.minute)
        println(s"Successfully created '$ns' on Kubernetes cluster")

      case config: ConfigMap =>
        val createConfig = createOrUpdate(client, config)
        val cfg = Await.result(createConfig, 1.minute)
        println(s"Successfully created '$cfg' on Kubernetes cluster")

      case service: Service =>
        val createService = createOrUpdate(client, service)
        val svc = Await.result(createService, 1.minute)
        println(s"Successfully created '$svc' on Kubernetes cluster")

      case deployment: Deployment =>
        val createDeployment = createOrUpdate(client, deployment)
        val dpl = Await.result(createDeployment, 1.minute)
        println(s"Successfully created '$dpl' on Kubernetes cluster")
    }
  }

  def createOrUpdate[O <: ObjectResource](client: K8SRequestContext, o: O)(implicit fmt: Format[O], rd: ResourceDefinition[O]): Future[O] = {
    import skuber._

    client.create(o) recoverWith {
      case ex: K8SException if ex.status.code.contains(409) => client.update(o) // this need an abstraction
    }
  }

  // Run
  deploy()

  // Cleanup
  client.close
  //  super.close() // FIXME
}