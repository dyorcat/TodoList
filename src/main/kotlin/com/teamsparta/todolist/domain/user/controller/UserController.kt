package com.teamsparta.todolist.domain.user.controller

import com.teamsparta.todolist.domain.user.dto.CreateUserRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    val userService: UserService,
) {

    @PostMapping
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): ResponseEntity<UserResponse> {
        val user = userService.createUser(createUserRequest)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(user)
    }
}