package com.teamsparta.todolist.domain.comment.controller

import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.CreateCommentRequest
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/comments")
class CommentController(
    val commentService: CommentService,
) {
    @PostMapping
    fun createComment(@RequestBody createCommentRequest: CreateCommentRequest): ResponseEntity<CommentResponse> {
        val result = commentService.createComment(createCommentRequest)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(result)
    }

    @PutMapping("/{commentId}")
    fun updateComment(@PathVariable commentId: Long, @RequestBody updateCommentRequest: CreateCommentRequest): ResponseEntity<CommentResponse> {
        val arguments = UpdateCommentRequest(
            id = commentId,
            content = updateCommentRequest.content,
            nickname = updateCommentRequest.nickname,
            password = updateCommentRequest.password,
        )

        val comment = commentService.updateComment(arguments)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(comment)
    }

    @DeleteMapping("/{commentId}")
    fun deleteReply(@PathVariable commentId: Long, @RequestBody deleteCommentRequest: DeleteCommentRequest):
            ResponseEntity<Unit> {
        val arguments = DeleteCommentRequest(
            id = commentId,
            nickname = deleteCommentRequest.nickname,
            password = deleteCommentRequest.password
        )

        commentService.deleteComment(arguments)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null)
    }


}