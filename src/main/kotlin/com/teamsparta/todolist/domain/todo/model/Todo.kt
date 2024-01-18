package com.teamsparta.todolist.domain.todo.model

import jakarta.persistence.*
import org.h2.engine.User
import org.hibernate.annotations.CreationTimestamp
import java.time.ZonedDateTime

@Entity
@Table(name = "todo" )
class Todo(
    @Column
    var title: String,

    @Column
    var content: String? = null,

    @Column
    val nickname: String,

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now()

    @Column(name = "is_completed")
    private var _isCompleted: Boolean = false

    val isCompleted: Boolean
        get() = _isCompleted

    fun complete() {
        _isCompleted = true
    }

}