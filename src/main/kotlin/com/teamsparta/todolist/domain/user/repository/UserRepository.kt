package com.teamsparta.todolist.domain.user.repository

import com.teamsparta.todolist.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}