package com.knoldus.scalamvn.repository

import com.knoldus.scalamvn.models.User

trait UserRepository {

  def findAllUsers: Vector[User]
}
