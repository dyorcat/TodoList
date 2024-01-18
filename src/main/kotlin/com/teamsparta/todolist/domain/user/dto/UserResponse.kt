package com.teamsparta.todolist.domain.user.dto

import com.teamsparta.todolist.domain.user.model.User

data class UserResponse(
    val id: Long?,
    val username: String,
) {
    companion object{
        fun from(user: User): UserResponse {
            return UserResponse(
                id = user.id,
                username = user.username,
            )
        }
    }
}