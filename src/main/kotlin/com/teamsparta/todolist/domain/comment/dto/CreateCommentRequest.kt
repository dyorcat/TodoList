package com.teamsparta.todolist.domain.comment.dto

class CreateCommentRequest(
    val content: String,
    val nickname: String,
    val password: String,
    val todoId: Long,
)