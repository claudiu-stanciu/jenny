package com.stejr.jenny.convert

import org.scalatest.{FlatSpecLike, Matchers}

class CsvConverterSpec extends FlatSpecLike with Matchers {

  "Csv converter" should "convert a single data map to a single line CSV with header" in {
    val data = Map("name" -> "John", "age" -> 123)
    val delimiter = ","
    val expected =
      s"""name${delimiter}age
         |John${delimiter}123""".stripMargin
                                .replaceAll("\r", "")

    val converter = new CsvConverter(delimiter)
    converter.run(data) shouldBe expected
  }

  "Csv converter" should "convert multiple data maps to a multi-line CSV with header" in {
    val data = List(Map("name" -> "John", "age" -> 123), Map("name" -> "Doe", "age" -> 7645))
    val delimiter = ","
    val expected =
      s"""name${delimiter}age
         |John${delimiter}123
         |Doe${delimiter}7645""".stripMargin
                                .replaceAll("\r", "")

    val converter = new CsvConverter(delimiter)
    converter.run(data) shouldBe expected
  }

  "Csv converter" should "convert multiple data maps to a multi-line CSV without header" in {
    val data = List(Map("name" -> "John", "age" -> 123), Map("name" -> "Doe", "age" -> 7645))
    val delimiter = ","
    val expected =
      s"""John${delimiter}123
         |Doe${delimiter}7645""".stripMargin
                                .replaceAll("\r", "")

    val converter = new CsvConverter(delimiter = delimiter, hasHeader = false)
    converter.run(data) shouldBe expected
  }
}
