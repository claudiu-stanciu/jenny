package com.stejr.jenny.convert

import scala.collection.mutable.ListBuffer

class CsvConverter(delimiter: String, hasHeader: Boolean = true) extends Converter {

  /**
   * Convert data map into a CSV format representation. See [[Converter.run()]]
   *
   * @param data
   * @return CSV formatted string
   */
  override def run(data: Map[String, Any]): String = {
    run(List(data))
  }

  /**
   * Convert list of data maps into a CSV format representation. See [[Converter.run()]]
   *
   * @param data
   * @return CSV formatted string
   */
  override def run(data: List[Map[String, Any]]): String = {
    val out = new ListBuffer[String]

    if (hasHeader) out += data.head.keys.mkString(delimiter)

    // TODO: implement depth converter/explode function
    out ++= data.map(m => m.map(_._2).mkString(delimiter))
    out.mkString("\n")
  }
}
