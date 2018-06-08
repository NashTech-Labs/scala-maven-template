package com.knoldus.scalamvn.config

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{Directives, Route}
import com.knoldus.scalamvn.controllers.{BaseRoute, UserRoute}
import com.softwaremill.macwire.wire

trait ControllerConfig extends ServiceConfig {

  val seq: Seq[BaseRoute] = Seq (
    wire[UserRoute]
  )

  val routes: Route = seq.foldLeft[Route](Directives.reject) {
    case (acc, route) => acc ~ route.route
  }
}
