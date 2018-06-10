package com.knoldus.scalamvn.repository.impl

import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType.N
import com.amazonaws.services.dynamodbv2.{AmazonDynamoDB, AmazonDynamoDBClientBuilder}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{AsyncFlatSpec, BeforeAndAfterAll}

trait DynamoTestTrait extends AsyncFlatSpec with BeforeAndAfterAll with MockitoSugar {

  var client: AmazonDynamoDB = _

  override def beforeAll(): Unit = {
    val localArgs = Array("-inMemory", "-sharedDb", "1")
    val server = ServerRunner.createServerFromCommandLineArgs(localArgs)
    System.setProperty("sqlite4java.library.path", "native-libs")
    client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
      new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", ""))
      .build()
    server.start()

    LocalDynamoDB.createTable(client)("asyncItems")('id -> N)
  }

  override def afterAll(): Unit = {
    client.shutdown()
  }
}
