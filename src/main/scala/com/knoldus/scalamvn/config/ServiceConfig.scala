package com.knoldus.scalamvn.config

import com.knoldus.scalamvn.repository.components.{CoffeesComponent, CoffeesTable}
import com.knoldus.scalamvn.service.UserService
import com.knoldus.scalamvn.service.impl.UserServiceImpl
import com.softwaremill.macwire.wire

trait ServiceConfig extends RepositoryConfig {

  lazy val userService: UserService = wire[UserServiceImpl]
  lazy val coffeesComponent: CoffeesTable = wire[CoffeesComponent]
}
