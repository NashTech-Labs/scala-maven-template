package com.knoldus.scalamvn.service

import com.knoldus.scalamvn.models.User

trait UserService {

  def findUsers: Vector[User]
}
