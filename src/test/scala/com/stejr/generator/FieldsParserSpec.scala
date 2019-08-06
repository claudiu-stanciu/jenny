package com.stejr.generator

import scala.io.Source

import org.scalatest.{FlatSpecLike, Matchers}

class FieldsParserSpec extends FlatSpecLike with Matchers {
  "FieldsParser" should "parse json-string contents to a map of field types" in {
    val contents = Source.fromResource("fields.json").getLines().mkString("\n")
    val parsed = FieldsParser.get(contents)

    val expected = Map(
      "person" -> Map(
        "type" -> "object",
        "properties" -> Map(
          "name" -> Map("type" -> "string"),
          "age" -> Map("type" -> "integer")
        )
      )
    )

    parsed shouldBe expected
  }

}
