package com.teamsparta.todolist.domain.todo.model

import com.teamsparta.todolist.domain.comment.model.Comment
import jakarta.persistence.*
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

    @OneToMany(mappedBy = "todo")
    val comments: List<Comment> = emptyList(),

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