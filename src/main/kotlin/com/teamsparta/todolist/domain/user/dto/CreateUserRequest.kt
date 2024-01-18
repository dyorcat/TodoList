package com.teamsparta.todolist.domain.user.dto

import com.teamsparta.todolist.domain.user.model.User

data class CreateUserRequest(
    val username: String,
    val password: String,
) {
    fun to(): User {
        return User(
            username = username,
            password = password,
        )
    }
}