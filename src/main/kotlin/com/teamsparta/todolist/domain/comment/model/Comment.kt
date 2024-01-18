package com.teamsparta.todolist.domain.comment.model

import com.teamsparta.todolist.domain.todo.model.Todo
import jakarta.persistence.*

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var content: String,

    @Column
    val nickname: String,

    @Column
    val password: String,

    @ManyToOne
    var todo: Todo
) {

    fun changeContent(content: String) {
        this.content = content
    }

    fun checkAuthentication(nickname: String, password: String) {
        if (nickname != this.nickname) {
            throw Exception("잘 못 된 인증입니다.")
        }

        if (password != this.password) {
            throw Exception("잘 못 된 인증입니다.")
        }
    }
}