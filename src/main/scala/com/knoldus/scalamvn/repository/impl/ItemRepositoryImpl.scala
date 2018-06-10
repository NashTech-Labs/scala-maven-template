package com.knoldus.scalamvn.repository.impl

import akka.stream.alpakka.dynamodb.scaladsl.DynamoClient
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult
import com.gu.scanamo.ScanamoAlpakka
import com.gu.scanamo.error.DynamoReadError
import com.gu.scanamo.query.{KeyEquals, UniqueKey}
import com.knoldus.scalamvn.models.Item
import com.knoldus.scalamvn.repository.ItemRepository
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ItemRepositoryImpl(dBClient: DBClient) extends ItemRepository {
  val client: DynamoClient = dBClient.client
  val tableName = "asyncItems"

  override def put(item: Item): Future[Option[Either[DynamoReadError, Item]]] =
    ScanamoAlpakka.put(client)(tableName)(item)

  override def get(id: Long): Future[Option[Either[DynamoReadError, Item]]] =
    ScanamoAlpakka.get[Item](client)(tableName)(UniqueKey(KeyEquals('id, id)))

  override def delete(id: Long): Future[DeleteItemResult] =
    ScanamoAlpakka.delete[Item](client)(tableName)(UniqueKey(KeyEquals('id, id)))

  override def readAll: Future[List[Either[DynamoReadError, Item]]] =
    ScanamoAlpakka.scan[Item](client)(tableName)

}
