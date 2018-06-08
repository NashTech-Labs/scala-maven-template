package com.knoldus.scalamvn.util

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.knoldus.scalamvn.models.{CoffeeList, Coffees}

trait JsonHelper extends SprayJsonSupport  {
  import spray.json.DefaultJsonProtocol._

  implicit val coffees = jsonFormat5(Coffees)
  implicit val coffeesList = jsonFormat1(CoffeeList)
}
