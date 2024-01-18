package com.teamsparta.todolist.domain.todo.dto

import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.todo.model.Todo
import java.time.ZonedDateTime

class RetrieveTodoResponse (
    val id: Long?,
    val title: String,
    val content: String?,
    val nickname: String,
    val isCompleted: Boolean,
    val createdAt: ZonedDateTime,
    val comments: List<CommentResponse>
){
    companion object {
        fun from(todo: Todo): RetrieveTodoResponse {
            return RetrieveTodoResponse(
                id = todo.id,
                title = todo.title,
                content = todo.content,
                nickname = todo.nickname,
                isCompleted = todo.isCompleted,
                createdAt = todo.createdAt,
                comments = todo.comments.map {CommentResponse.from(it) }
            )
        }
    }
}