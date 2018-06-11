package com.knoldus.scalamvn.repository

import com.amazonaws.services.dynamodbv2.model.DeleteItemResult
import com.gu.scanamo.error.DynamoReadError
import com.knoldus.scalamvn.models.Employee

import scala.concurrent.Future

trait EmployeeRepository {

  def put(employee: Employee): Future[Option[Either[DynamoReadError, Employee]]]

  def get(name: String, id: Long): Future[Option[Either[DynamoReadError, Employee]]]

  def delete(name: String): Future[DeleteItemResult]

  def readAll: Future[List[Either[DynamoReadError, Employee]]]

  def query(name: String): Future[List[Either[DynamoReadError, Employee]]]
}
