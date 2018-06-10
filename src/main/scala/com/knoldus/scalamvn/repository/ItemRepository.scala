package com.knoldus.scalamvn.repository

import com.amazonaws.services.dynamodbv2.model.DeleteItemResult
import com.gu.scanamo.error.DynamoReadError
import com.knoldus.scalamvn.models.Item

import scala.concurrent.Future

trait ItemRepository {

  def put(items: Item): Future[Option[Either[DynamoReadError, Item]]]

  def get(id: Long): Future[Option[Either[DynamoReadError, Item]]]

  def delete(id: Long): Future[DeleteItemResult]

  def readAll: Future[List[Either[DynamoReadError, Item]]]

}
