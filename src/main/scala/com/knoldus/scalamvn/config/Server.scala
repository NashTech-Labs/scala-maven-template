package com.knoldus.scalamvn.config

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContext

class Server(implicit val system: ActorSystem, dispatcher: ExecutionContext, materializer: ActorMaterializer) {

  private val config = ConfigFactory.load()

  val host = config.getString("server.host")
  val port = config.getInt("server.port")

  def bind(routes: Route) = Http().bindAndHandle(Route.handlerFlow(routes), host, port)
}
