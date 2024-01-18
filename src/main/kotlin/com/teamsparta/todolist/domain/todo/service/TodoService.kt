package com.teamsparta.todolist.domain.todo.service

interface TodoService {
    fun getTodoList()

    fun getTodoById()

    fun createTodo()

    fun updateTodo()

    fun deleteTodo()
}