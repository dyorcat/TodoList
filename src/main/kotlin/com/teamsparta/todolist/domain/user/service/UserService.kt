package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.user.dto.CreateUserRequest
import com.teamsparta.todolist.domain.user.dto.SignInRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse


interface UserService {
    fun createUser(createUserArguments: CreateUserRequest): UserResponse
    fun signIn(signInArguments: SignInRequest): UserResponse
}