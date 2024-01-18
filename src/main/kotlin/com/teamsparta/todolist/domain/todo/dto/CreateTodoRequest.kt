package com.teamsparta.todolist.domain.todo.dto

data class CreateTodoRequest(
    val title: String,
    val content: String?,
)
