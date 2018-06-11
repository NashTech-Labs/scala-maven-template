package com.knoldus.scalamvn.repository.impl

import akka.stream.alpakka.dynamodb.scaladsl.DynamoClient
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult
import com.gu.scanamo.ScanamoAlpakka
import com.gu.scanamo.error.DynamoReadError
import com.gu.scanamo.query._
import com.knoldus.scalamvn.models.Employee
import com.knoldus.scalamvn.repository.EmployeeRepository
import com.gu.scanamo.syntax._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class EmployeeRepositoryImpl(dBClient: DBClient) extends EmployeeRepository {
  private val client: DynamoClient = dBClient.client
  private val tableName = "Employees"

  override def put(employee: Employee): Future[Option[Either[DynamoReadError, Employee]]] =
    ScanamoAlpakka.put(client)(tableName)(employee)

  override def get(name: String, id: Long): Future[Option[Either[DynamoReadError, Employee]]] =
    ScanamoAlpakka.get[Employee](client)(tableName)(UniqueKey('name -> name and 'id -> id))

  override def delete(name: String): Future[DeleteItemResult] =
    ScanamoAlpakka.delete[Employee](client)(tableName)(UniqueKey(KeyEquals('name, name)))

  override def readAll: Future[List[Either[DynamoReadError, Employee]]] =
    ScanamoAlpakka.scan[Employee](client)(tableName)

  override def query(name: String): Future[List[Either[DynamoReadError, Employee]]] =
  ScanamoAlpakka.query[Employee](client)(tableName)('name -> name and 'id > 0)
}
