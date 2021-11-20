package com.kingOf0.askit.business.abstract

import com.kingOf0.askit.entity.concrete.Message
import com.kingOf0.hellospring.core.utilities.results.DataResult
import com.kingOf0.hellospring.core.utilities.results.Result

interface IMessageService {

    fun getVerifiedMessages() : DataResult<List<Message>>
    fun getAllMessages(): DataResult<List<Message>>
    fun addMessage(message: Message) : Result
    fun getUnverifiedMessages(): DataResult<List<Message>>
    fun verifyMessage(id: Long, verify: Boolean = true) : Result
}