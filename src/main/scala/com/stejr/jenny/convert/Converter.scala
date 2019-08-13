package com.stejr.jenny.convert

trait Converter {

  /**
   * Convert data map into a file format representation
   *
   * @param data
   * @return
   */
  def run(data: Map[String, Any]): String

  /**
   * Convert list of data maps into a file format representation
   * @param data
   * @return
   */
  def run(data: List[Map[String, Any]]): String
}
