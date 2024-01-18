package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.user.dto.CreateUserRequest
import com.teamsparta.todolist.domain.user.dto.SignInRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.model.User
import com.teamsparta.todolist.domain.user.repository.UserRepository
import com.teamsparta.todolist.infra.security.jwt.JwtPlugin
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin,
) : UserService {
    override fun createUser(createUserArguments: CreateUserRequest): UserResponse {
        val user = User(
            username = createUserArguments.username,
            password = passwordEncoder.encode(createUserArguments.password),
        )

        val createdUser = userRepository.save(user)

        val token = jwtPlugin.generateAccessToken(
            subject = user.id.toString(),
            username = user.username,
        )

        return UserResponse.from(createdUser, token)
    }

    override fun signIn(signInArguments: SignInRequest): UserResponse {
        val user = userRepository.findByUsername(signInArguments.username)
            ?: throw Exception("user is not found")

        if (user.username != signInArguments.username ||
            !passwordEncoder.matches(signInArguments.password, user.password)
        ) {
            throw Exception("authentication failed")
        }

        val token = jwtPlugin.generateAccessToken(
            subject = user.id.toString(),
            username = user.username,
        )

        return UserResponse.from(user, token)
    }
}