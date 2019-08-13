package com.stejr.jenny.integration

import scala.io.Source

import com.stejr.jenny.convert.CsvConverter
import com.stejr.jenny.schema.Generator
import com.stejr.jenny.sink.StdOutSink
import org.scalatest.{FlatSpec, Matchers}

class IntegrationSpec extends FlatSpec with Matchers {

  "jenny" should "read a json schema and generate a csv string with one entry" in {
    val json = Source.fromResource("fields.json").getLines().mkString("\n")
    val data = Generator.run(json)
    val converter = new CsvConverter()
    val csvData = converter.run(data)

    implicit val ec = scala.concurrent.ExecutionContext.global
    val sink = new StdOutSink()

    // TODO add check for printing to console
    sink.send(csvData)

    /**
     * should look like this:
     * ===>>>>>
     * name,age
     * lOcgydfwpsuiYxgjvvwlduwfpjlfKps,932
     * <<<<<===
     */

    // checking to have header + 1 line for the random data
    csvData.split("\n") should have length 2
  }

  it should "read a json schema and generate a csv string with 3 entries" in {
    val json = Source.fromResource("fields.json").getLines().mkString("\n")
    val entries = 3
    val data = (0 until entries).toList.map(_ => Generator.run(json))
    val converter = new CsvConverter()
    val csvData = converter.run(data)

    implicit val ec = scala.concurrent.ExecutionContext.global
    val sink = new StdOutSink()

    // TODO add check for printing to console
    sink.send(csvData)

    /**
     * should look like this:
     * ===>>>>>
     * name,age
     * fhybwitztmlgekbhpxxixyNanqVnowknissay,701
     * HupvocXfgficbfknxztgdvswNclmzpzrz,826
     * pyxrvoxodmeujqEucwmyuivvab,940
     * <<<<<===
     */

    // checking to have header + 3 lines for the random data
    csvData.split("\n") should have length entries + 1
  }
}
