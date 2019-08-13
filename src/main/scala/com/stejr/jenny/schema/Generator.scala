package com.stejr.jenny.schema

import org.scalacheck.Gen

/**
 * Generate values for given case class
 */
object Generator {

  /**
   * Generate data struct with random values for fileds, based on json schema
   */
  def run(fieldsSchema: String): Map[String, Any] = {
    val fields = FieldsParser.get(fieldsSchema)

    fields.map {
      case (fieldName: String, fieldTypeRaw: Any) => {
        val fieldType = fieldTypeRaw.asInstanceOf[Map[String, String]]("type")
        val generated = random(fieldName, fieldType)
        (generated.name, generated.value)
      }
    }
  }

  /**
   * Pass a field definition, and generate data record
   *
   * @return
   */
  def random(fieldName: String, fieldType: String): Record = {
    val gen = resolveGenerator(fieldType)
    Record(fieldName, gen.sample.get)
  }

  def random(field: FieldType): Record = {
    random(field.name, field.fieldType)
  }

  def resolveGenerator(fieldType: String): Gen[Any] = {
    fieldType.toLowerCase match {
      case "string" => Gen.alphaStr
      case "integer" => Gen.choose(0, 1000)
    }
  }

}
