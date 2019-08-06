package com.stejr.jenny

import scala.io.Source

import org.scalatest.{FlatSpecLike, Matchers}

class GeneratorSpec extends FlatSpecLike with Matchers {

  "Generator" should "create some random data for a field name and type string" in {
    val field = FieldType("fieldName", "string")

    val generated = Generator.random(field)
    generated.name shouldBe field.name
    generated.value shouldBe a [String]
  }

  it should "create some random data for a field name and type int" in {
    val field = FieldType("fieldName", "integer")

    val generated = Generator.random(field)
    generated.name shouldBe field.name
    generated.value shouldBe a [Int]
  }

  it should "read fields json schema and produce random data" in {
    val json = Source.fromResource("fields.json").getLines().mkString("\n")
    val data = Generator.run(json)
    data.keys.toList should have length 2
    data("name") shouldBe a [String]
    data("age") shouldBe a [Int]
  }
}
