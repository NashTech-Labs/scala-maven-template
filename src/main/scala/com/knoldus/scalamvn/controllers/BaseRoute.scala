package com.knoldus.scalamvn.controllers

import akka.http.scaladsl.server.{Directives, Route}

trait BaseRoute extends Directives {

  def route: Route
}
