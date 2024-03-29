package com.teamsparta.todolist.domain.todo.dto

import com.teamsparta.todolist.domain.todo.model.Todo
import java.time.ZonedDateTime

data class TodoResponse(
    val title: String,
    val content: String?,
    val nickname: String,
    val createdAt: ZonedDateTime,
    val isCompleted: Boolean
) {

    companion object {
        fun from(todo: Todo): TodoResponse {
            return TodoResponse(
                title = todo.title,
                content = todo.content,
                nickname = todo.nickname,
                createdAt = todo.createdAt,
                isCompleted = todo.isCompleted
            )
        }
    }
}
