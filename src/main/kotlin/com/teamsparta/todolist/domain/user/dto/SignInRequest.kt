package com.teamsparta.todolist.domain.user.dto

data class SignInRequest(
    val username: String,
    val password: String,
)