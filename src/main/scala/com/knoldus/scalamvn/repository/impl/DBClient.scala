package com.knoldus.scalamvn.repository.impl

import akka.stream.alpakka.dynamodb.impl.DynamoSettings
import akka.stream.alpakka.dynamodb.scaladsl.DynamoClient
import com.knoldus.scalamvn.config.AkkaConfig

class DBClient extends AkkaConfig {

  val settings = DynamoSettings(system)
  val client = DynamoClient(settings)
}
