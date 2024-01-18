package com.teamsparta.todolist.domain.todo.service

import com.teamsparta.todolist.domain.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.todo.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todo.dto.RetrieveTodoResponse
import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import com.teamsparta.todolist.domain.todo.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todo.model.Todo
import com.teamsparta.todolist.domain.todo.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.ui.Model

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository,
): TodoService
{
    override fun findAll(): List<TodoResponse> {
        val foundTodos = todoRepository.findAllByOrderByCreatedAtDesc()
        return foundTodos.map { TodoResponse.from(it) }
    }

    override fun findAll(nickname: String?, sort: String?): List<TodoResponse> {
        nickname?.let {
            return todoRepository.findAllByNickname(nickname)
                .map { TodoResponse.from(it) }
        }
        return if (sort == "createdAt") {
            todoRepository.findAllByOrderByCreatedAtAsc()
        } else {
            todoRepository.findAllByOrderByCreatedAtDesc()
        }.map { TodoResponse.from(it) }
    }



    override fun findById(todoId: Long): RetrieveTodoResponse? {
        val foundTodo: Todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        return foundTodo.let{ RetrieveTodoResponse.from(it)}
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        val savedTodo = todoRepository.save(
            Todo(title = request.title,
                content = request.content,
                nickname = request.nickname
            )
        )
        return TodoResponse.from(savedTodo)
    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        val updatedTodo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        val (title, content) = request

        updatedTodo.title = title
        updatedTodo.content = content
        return TodoResponse.from(updatedTodo)
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        todoRepository.deleteById(todoId)
    }

    override fun completeTodo(todoId: Long) {
        val targetTodo = todoRepository.findByIdOrNull(todoId)

        targetTodo?.let{ it.complete()
            todoRepository.save(it)
        }
    }
}