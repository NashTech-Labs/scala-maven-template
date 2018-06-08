package com.knoldus.scalamvn.controllers

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{as, complete, entity, get, path, post}
import akka.http.scaladsl.server.Route
import com.knoldus.scalamvn.models.{CoffeeList, Coffees}
import com.knoldus.scalamvn.repository.components.CoffeesTable
import com.knoldus.scalamvn.service.UserService
import com.knoldus.scalamvn.util.JsonHelper
import scala.concurrent.ExecutionContext.Implicits.global

class UserRoute(userService: UserService, coffeeComponent: CoffeesTable) extends BaseRoute with JsonHelper {

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
  } ~ post {
    path("addCoffees") {
      entity(as[Coffees]) { coffees =>
        coffeeComponent.addCoffees(coffees)
        complete("Coffee added successfully")
      }
    }
  } ~ get {
    path("getCoffees") {
      complete {
        coffeeComponent.getCoffees().map (coffees => CoffeeList(coffees))
      }
    }
  }
}
