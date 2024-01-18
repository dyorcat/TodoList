package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.CreateCommentRequest
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest

interface CommentService {
    fun createComment(createCommentRequest: CreateCommentRequest): CommentResponse
    fun updateComment(updateCommentRequest: UpdateCommentRequest): CommentResponse
    fun deleteComment(deleteCommentRequest: DeleteCommentRequest)
}