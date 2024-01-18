package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.user.dto.CreateUserRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
): UserService {
    override fun createUser(createUserRequest: CreateUserRequest): UserResponse {
        val createdUser = userRepository.save(createUserRequest.to())
        return UserResponse.from(createdUser)
    }
}