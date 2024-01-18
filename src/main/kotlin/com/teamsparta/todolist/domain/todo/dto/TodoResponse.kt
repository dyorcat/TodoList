package com.teamsparta.todolist.domain.todo.dto

import com.teamsparta.todolist.domain.todo.model.Todo
import java.time.ZonedDateTime

data class TodoResponse(
    val id: Long?,
    val title: String,
    val content: String?,
    val nickname: String,
    val createdAt: ZonedDateTime,
) {

    companion object {
        fun from(todo: Todo): TodoResponse {
            return TodoResponse(
                id = todo.id,
                title = todo.title,
                content = todo.content,
                nickname = todo.nickname,
                createdAt = todo.createdAt,
            )
        }
    }
}
