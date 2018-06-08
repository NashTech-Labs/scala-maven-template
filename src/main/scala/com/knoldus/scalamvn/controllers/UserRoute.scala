package com.knoldus.scalamvn.controllers

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Route
import com.knoldus.scalamvn.service.UserService

class UserRoute(userService: UserService) extends BaseRoute {

  val route: Route = {
    path("ping") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>pong</h1>"))
      }
    }
  } ~
  path("users") {
    get {
      complete {
        println(userService.findUsers)
        HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>users</h1>")
      }
    }
  }


}
