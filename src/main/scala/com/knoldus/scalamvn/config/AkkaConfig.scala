package com.knoldus.scalamvn.config

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext

trait AkkaConfig {

  implicit val system: ActorSystem = ActorSystem()

  implicit val dispatcher: ExecutionContext = system.dispatcher

  implicit val materializer: ActorMaterializer = ActorMaterializer()

}
