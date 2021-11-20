package com.kingOf0.askit.dataaccess.abstract

import com.kingOf0.askit.entity.concrete.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface IMessageDAO : JpaRepository<Message, Long> {

    @Query("FROM Message WHERE isVerified = true")
    fun getVerifiedMessages() : List<Message>

    @Query("FROM Message WHERE isVerified = false")
    fun getUnVerifiedMessages() : List<Message>

    @Modifying
    @Query("UPDATE Message m SET m.isVerified = :verify where m.id = :id")
    fun verifyMessage(id: Long, verify: Boolean)

}