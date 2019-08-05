package com.stejr.generator

import org.scalatest.{FlatSpecLike, Matchers}

class GeneratorSpec extends FlatSpecLike with Matchers  {

  "Generator" should "create some random data for a field name and type string" in {
    val field = FieldType("field1", "string")

    val generated = Generator.generate(field)
    generated.name shouldBe field.name
    generated.value shouldBe a [String]
  }
}
