package com.teamsparta.todolist.domain.comment.dto

import com.teamsparta.todolist.domain.comment.model.Comment

class CommentResponse(
    var id: Long?,
    val content: String,
    val nickname: String,
    var todoId: Long,
) {
    companion object {
        fun from(comment: Comment): CommentResponse {
            return CommentResponse(
                id = comment.id,
                content = comment.content,
                nickname = comment.nickname,
                todoId = comment.todo.id ?: throw Exception("존재하지 않는 할일카드입니다. ")
            )
        }
    }
}

