package com.knoldus.scalamvn.config

import com.knoldus.scalamvn.repository.UserRepository
import com.knoldus.scalamvn.repository.impl.UserRepositoryImpl
import com.softwaremill.macwire.wire

trait RepositoryConfig {

  lazy val userRepository: UserRepository = wire[UserRepositoryImpl]
}
