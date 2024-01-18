package com.teamsparta.todolist.domain.user.dto

import com.teamsparta.todolist.domain.user.model.User

data class UserResponse(
    val id: Long?,
    val username: String,
    val token: String? = null,
) {
    companion object{
        fun from(user: User, token: String?): UserResponse {
            return UserResponse(
                id = user.id,
                username = user.username,
                token = token,
            )
        }
    }
}