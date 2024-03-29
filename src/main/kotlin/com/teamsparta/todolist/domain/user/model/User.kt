package com.teamsparta.todolist.domain.user.model

import jakarta.persistence.*
import org.yaml.snakeyaml.tokens.AliasToken

@Entity(name = "todo_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    val username: String,
    @Column
    val password: String,
)