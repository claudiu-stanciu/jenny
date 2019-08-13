package com.stejr.jenny.sink

import scala.concurrent.{ExecutionContext, Future}

class StdOutSink(implicit context: ExecutionContext) extends Sink {
  /**
   * Send data to sink
   *
   * @param data
   * @return
   */
  override def send(data: String): Future[Unit] = Future {
    println(data)
  }

}
