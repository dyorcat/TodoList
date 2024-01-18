package com.teamsparta.todolist.domain.todo.controller

import com.teamsparta.todolist.domain.todo.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todo.dto.RetrieveTodoResponse
import com.teamsparta.todolist.domain.todo.dto.TodoResponse
import com.teamsparta.todolist.domain.todo.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos")
@RestController
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping()
    fun findAllTodo(@RequestParam nickname: String?,
        @RequestParam sort: String?,
    ): ResponseEntity<List<TodoResponse>> {
        val todos = todoService.findAll(nickname, sort)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.findAll())
    }

    @GetMapping("/{todoId}")
    fun getTodoById(@PathVariable todoId: Long): ResponseEntity<RetrieveTodoResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.findById(todoId))
    }

    @PostMapping
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(createTodoRequest))
    }

    @PutMapping("/{todoId}")
    fun updateTodo(@PathVariable todoId: Long,
                   @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.updateTodo(todoId, updateTodoRequest))
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Unit> {
        todoService.deleteTodo(todoId)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @PatchMapping("/{todoId}/complete")
    fun completeTodo(@PathVariable todoId: Long): ResponseEntity<Unit> {
        todoService.completeTodo(todoId)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(null)
    }



}