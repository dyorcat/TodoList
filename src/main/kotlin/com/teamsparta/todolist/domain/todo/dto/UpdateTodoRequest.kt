package com.teamsparta.todolist.domain.todo.dto

data class UpdateTodoRequest(
    val title: String,
    val content: String?,
)
