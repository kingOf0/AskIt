package com.kingOf0.askit.api

import com.kingOf0.askit.business.abstract.IMessageService
import com.kingOf0.askit.core.utilities.results.DataResult
import com.kingOf0.askit.core.utilities.results.Result
import com.kingOf0.askit.entity.concrete.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/messages")
class MessagesController @Autowired constructor(
    private val messageService: IMessageService
){

    @GetMapping("getVerified")
    fun getVerifiedMessages(): DataResult<List<Message>> {
        return messageService.getVerifiedMessages()
    }

    @GetMapping("getUnVerified")
    fun getUnVerifiedMessages(): DataResult<List<Message>> {
        return messageService.getUnverifiedMessages()
    }

    @GetMapping("getAllMessages")
    fun getAllMessages(): DataResult<List<Message>> {
        return messageService.getAllMessages()
    }

    @PostMapping
    fun addMessage(@RequestBody message: Message) : Result {
        return messageService.addMessage(message)
    }

    @PatchMapping
    fun verifyMessage(@RequestParam verify: Boolean, @RequestParam id: Long) : Result {
        return messageService.verifyMessage(id, verify)
    }
}