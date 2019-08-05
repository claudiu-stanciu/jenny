package com.stejr.generator

import org.scalacheck._

/**
 * Generate values for given case class
 */
object Generator {

  /**
   * Pass a field definition, and generate data record
   * @param field
   * @return
   */
  def generate(field: FieldType): Record = {
    Record(field.name, Gen.alphaStr.sample.get)
  }
}
