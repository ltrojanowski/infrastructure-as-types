package com.virtuslab.dsl.v2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class InterpreterDerivationTest extends AnyFlatSpec with Matchers {

  it should "work" in {
    import openApi.interpreters._ // needed
    import openApi.implementation.json4s._
    import openApi.implementation.json4s.Transformer._ // needed

    val namespace: Namespace = Namespace("foo")

    case class MyDef(
        superApp: Application = Application(name = "bar"),
        myConfiguration: Configuration = Configuration(name = "config-foo", data = Map.empty),
        mySecret: Secret = Secret("config-foo", data = Map.empty))

    val myNs = MyDef()

    val myDefInterpreter = Interpreter.gen[MyDef]
    val r = myDefInterpreter.interpret(myNs, namespace)
    println(r)
  }

}