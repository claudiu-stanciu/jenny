package com.stejr.jenny.schema

import org.json4s.native.JsonMethods.parse

object FieldsParser {
  def get(content: String): Map[String, Any] = {
    // taking only the first set of properties
    val definitions = parse(content) \\ "properties"
    definitions.values.asInstanceOf[Map[String, Any]]
  }
}
