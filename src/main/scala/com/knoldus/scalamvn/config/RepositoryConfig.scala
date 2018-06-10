package com.knoldus.scalamvn.config

import com.knoldus.scalamvn.repository.impl._
import com.knoldus.scalamvn.repository.{ItemRepository, UserRepository}
import com.softwaremill.macwire.wire

trait RepositoryConfig {
  lazy val userRepository: UserRepository = wire[UserRepositoryImpl]
  lazy val itemRepository: ItemRepository = wire[ItemRepositoryImpl]
  lazy val dBClient: DBClient = wire[DBClient]
}
