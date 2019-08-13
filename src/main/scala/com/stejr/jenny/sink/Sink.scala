package com.stejr.jenny.sink

import scala.concurrent.Future

/**
 * Define an interface to send data to -> sink
 */
trait Sink {

  /**
   * Send data to sink
   *
   * @param data
   * @return
   */
  def send(data: String): Future[Unit]


}
