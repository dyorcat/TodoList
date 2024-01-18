package com.teamsparta.todolist.infra.security

import com.teamsparta.todolist.domain.user.model.User

data class UserPrincipal(
    val id: Long,
    val username: String,
) {
    fun to(): User {
        return User(
            id = id,
            username = username,
            password = "",
        )
    }
}