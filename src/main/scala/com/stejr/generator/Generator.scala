package com.stejr.generator

import org.scalacheck._

/**
 * Generate values for given case class
 */
object Generator {

  /**
   * Pass a field definition, and generate data record
   *
   * @return
   */
  def generate(fieldName: String, fieldType: String): Record = {
    val gen = resolveGenerator(fieldType)
    Record(fieldName, gen.sample.get)
  }

  def generate(field: FieldType): Record = {
    generate(field.name, field.fieldType)
  }

  def resolveGenerator(fieldType: String): Gen[Any] = {
    fieldType.toLowerCase match {
      case "string" => Gen.alphaStr
      case "integer" => Gen.choose(0, 1000)
    }
  }

  def generate(fields: Seq[FieldType]): Seq[Record] = {
    fields.map(f => generate(f))
  }

}
