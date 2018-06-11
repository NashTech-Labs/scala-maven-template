package com.knoldus.scalamvn.repository.impl

import com.knoldus.scalamvn.models.{Code, Item}
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType._

class ItemRepositoryImplTest extends DynamoTestTrait {

  val dDClient = new DBClient
  val itemImpl = new ItemRepositoryImpl(dDClient)

  override def beforeAll(): Unit = {
    super.beforeAll()
    LocalDynamoDB.createTable(client)("asyncItems")('id -> N)
  }

  it should "put the item" in {
    val id = scala.util.Random.nextInt()
    val item = Item(id, "name", Code(List("code1")))
    val futureRes = itemImpl.put(item)
    futureRes.map(res => assert(res === None))
  }

  it should "put & get the item" in {
    val id = scala.util.Random.nextInt()
    val item = Item(id, "name", Code(List("code2")))
    val futureRes = for {
      _ <- itemImpl.put(item)
      res <- itemImpl.get(id)
    } yield res
    futureRes.map(res => assert(res === Some(Right(Item(id, "name", Code(List("code2")))))))
  }

  it should "delete the item" in {
    val id = scala.util.Random.nextInt()
    val item = Item(id, "name", Code(List("code3")))
    val futureRes = for {
      _ <- itemImpl.put(item)
      resBeforeDelete <- itemImpl.get(id)
      _ <- itemImpl.delete(id)
      resAfterDelete <- itemImpl.get(id)
    } yield (resBeforeDelete, resAfterDelete)

    futureRes.map {
      case (resBeforeDelete, resAfterDelete) => assert(resBeforeDelete === Some(Right(Item(id, "name", Code(List("code3")))))
        && resAfterDelete === None)
    }
  }

  it should "get all the items" in {
    val futureRes = itemImpl.readAll
    futureRes.map(list => assert(list.nonEmpty))
  }
}
