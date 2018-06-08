package com.knoldus.scalamvn.repository.impl

import com.knoldus.scalamvn.models.User
import com.knoldus.scalamvn.repository.UserRepository

class UserRepositoryImpl extends UserRepository{
  override def findAllUsers: Vector[User] =
    Vector(User(13, "James", 29))
}
