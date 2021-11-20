package com.kingOf0.askit.business.concrete

import com.kingOf0.askit.business.abstract.IMessageService
import com.kingOf0.askit.dataaccess.abstract.IMessageDAO
import com.kingOf0.askit.entity.concrete.Message
import com.kingOf0.hellospring.core.utilities.results.DataResult
import com.kingOf0.hellospring.core.utilities.results.Result
import com.kingOf0.hellospring.core.utilities.results.SuccessDataResult
import com.kingOf0.hellospring.core.utilities.results.SuccessResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageManager @Autowired constructor(
    private val messageDAO: IMessageDAO
): IMessageService {

    override fun getVerifiedMessages() : DataResult<List<Message>> {
        return SuccessDataResult(messageDAO.getVerifiedMessages())
    }

    override fun getAllMessages(): DataResult<List<Message>> {
        return SuccessDataResult(messageDAO.findAll())
    }

    override fun addMessage(message: Message): Result {
        messageDAO.save(message)
        return SuccessResult()
    }

    override fun getUnverifiedMessages(): DataResult<List<Message>> {
        return SuccessDataResult(messageDAO.getUnVerifiedMessages())
    }

    override fun verifyMessage(id: Long, verify: Boolean): Result {
        return SuccessDataResult(messageDAO.verifyMessage(id, verify))
    }


}