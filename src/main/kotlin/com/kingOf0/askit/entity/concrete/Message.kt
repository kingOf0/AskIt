package com.kingOf0.askit.entity.concrete

import javax.persistence.*

@Entity
@Table(name="messages")
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "message")
    val message: String,

    @Column(name = "date")
    val date: Long,

    @Column(name = "is_verified")
    val isVerified: Boolean
)