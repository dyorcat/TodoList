package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.CreateCommentRequest
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.comment.repository.CommentRepository
import com.teamsparta.todolist.domain.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import kotlin.Exception

class CommentServiceImpl(
    val commentRepository: CommentRepository,
    val todoRepository: TodoRepository,
    ): CommentService {
    override fun createComment(createCommentRequest: CreateCommentRequest): CommentResponse {
        val targetTodo = todoRepository.findByIdOrNull(createCommentRequest.todoId)

            ?: throw Exception("존재하지 않는 할일카드 입니다.")

        val comment = Comment(
            content = createCommentRequest.content,
            nickname = createCommentRequest.nickname,
            password = createCommentRequest.password,
            todo = targetTodo,
        )

        val result = commentRepository.save(comment)

        return CommentResponse.from(result)
    }

    override fun updateComment(updateCommentRequest: UpdateCommentRequest): CommentResponse {
        val foundComment = updateCommentRequest.id?.let {
            commentRepository.findByIdOrNull(it)
        } ?: throw Exception("존재하지 않는 댓글입니다. ")

        if (foundComment.password != updateCommentRequest.password || foundComment.nickname != updateCommentRequest.nickname) {
            throw Exception("해당 댓글의 비밀번호와 일치하지 않습니다. ")
        }
        foundComment.checkAuthentication(updateCommentRequest.nickname, updateCommentRequest.password)

        foundComment.changeContent(updateCommentRequest.content)
        commentRepository.save(foundComment)
        return CommentResponse.from(foundComment)
    }

    override fun deleteComment(deleteCommentRequest: DeleteCommentRequest) {
        deleteCommentRequest.id?.let {
            commentRepository.deleteById(it)
            val foundComment = deleteCommentRequest.id?.let {
                commentRepository.findByIdOrNull(it) } ?: throw Exception("존재하지 않는 댓글입니다. ")

            if (foundComment.password != deleteCommentRequest.password || foundComment.nickname != deleteCommentRequest.nickname) {
                throw Exception("해당 댓글의 비밀번호와 일치하지 않습니다. ")
            }

            foundComment.checkAuthentication(deleteCommentRequest.nickname, deleteCommentRequest.password)

            commentRepository.deleteById(deleteCommentRequest.id)
        }
    }
}

