package com.teamsparta.todolist.domain.todo.dto

import java.util.Date

data class TodoResponse(
    val id: Long,
    val title: String,
    val content: String?,
    val nickname: String,
    val status: String,
    val createdAt: Date,
)
