package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.user.dto.CreateUserRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse


interface UserService {
    fun createUser(createUserRequest: CreateUserRequest): UserResponse
}