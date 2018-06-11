package com.knoldus.scalamvn.repository.impl

import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType._
import com.knoldus.scalamvn.models.Employee

class EmployeeRepositoryImplSuite extends DynamoTestTrait {

  val dDClient = new DBClient
  val employeeImpl = new EmployeeRepositoryImpl(dDClient)

  override def beforeAll(): Unit = {
    super.beforeAll()
    LocalDynamoDB.createTable(client)("Employees")('name -> S, 'id -> N)
  }

  it should "put and get the employee" in {
    val employee = Employee("name1", 12, List("abc12", "456we"))
    val futureRes = for {
      _ <- employeeImpl.put(employee)
      res <- employeeImpl.get("name1", 12)
    } yield res
    futureRes.map(res => assert(res === Some(Right(Employee("name1", 12, List("abc12", "456we"))))))
  }

  it should "put and query the employee" in {
    val employee1 = Employee("name1", -21, List("abc12", "456we"))
    val employee2 = Employee("name1", 22, List("abc12", "456we"))
    val employee3 = Employee("name2", -21, List("abc12", "456we"))
    val futureRes = for {
      _ <- employeeImpl.put(employee1)
      _ <- employeeImpl.put(employee2)
      _ <- employeeImpl.put(employee3)
      res <- employeeImpl.query("name1")
    } yield res
    futureRes.map(res => assert(res === List(
      Right(Employee("name1", 12, List("abc12", "456we"))),
      Right(Employee("name1", 22, List("abc12", "456we"))))))
  }
}
