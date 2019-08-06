package com.stejr.generator

import org.json4s._
import org.json4s.native.JsonMethods._

object FieldsParser {
  def get(content: String): Map[String, Any] = {
    val definitions = parse(content) \\ "definitions"
    definitions.values.asInstanceOf[Map[String, Any]]
  }
}
