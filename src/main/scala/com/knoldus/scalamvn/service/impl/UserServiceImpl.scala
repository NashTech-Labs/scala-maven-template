package com.knoldus.scalamvn.service.impl

import com.knoldus.scalamvn.models.User
import com.knoldus.scalamvn.repository.UserRepository
import com.knoldus.scalamvn.service.UserService

class UserServiceImpl(userRepository: UserRepository) extends UserService {

  override def findUsers: Vector[User] = userRepository.findAllUsers
}
