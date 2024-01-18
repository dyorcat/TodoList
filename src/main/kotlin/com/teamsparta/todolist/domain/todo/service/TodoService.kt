package com.teamsparta.todolist.domain.todo.service

import com.teamsparta.todolist.domain.todo.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todo.dto.RetrieveTodoResponse
import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import com.teamsparta.todolist.domain.todo.dto.UpdateTodoRequest

interface TodoService {
    fun findAll(): List<TodoResponse>

    fun findById(todoId: Long): RetrieveTodoResponse?

    fun createTodo(request: CreateTodoRequest): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse

    fun deleteTodo(todoId: Long)

    fun completeTodo(todoId: Long)
}