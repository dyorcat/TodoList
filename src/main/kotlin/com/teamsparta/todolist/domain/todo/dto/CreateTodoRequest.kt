package com.teamsparta.todolist.domain.todo.dto

import com.teamsparta.todolist.domain.todo.model.Todo

data class CreateTodoRequest(
    val title: String,
    val content: String?,
    val nickname: String,
) {

    fun to(): Todo {
        return Todo(
            title = title,
            content = content,
            nickname = nickname,
        )
    }
}
