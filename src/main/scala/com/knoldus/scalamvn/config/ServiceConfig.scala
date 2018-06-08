package com.knoldus.scalamvn.config

import com.knoldus.scalamvn.service.UserService
import com.knoldus.scalamvn.service.impl.UserServiceImpl
import com.softwaremill.macwire.wire

trait ServiceConfig extends RepositoryConfig {

  lazy val userService: UserService = wire[UserServiceImpl]
}
