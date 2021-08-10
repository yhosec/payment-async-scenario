package com.josep.asyncschenarioproducer.controller

import com.josep.asyncschenarioproducer.dto.PaymentRequestDto
import com.josep.asyncschenarioproducer.dto.PaymentResponseDto
import com.josep.asyncschenarioproducer.entity.Transaction
import com.josep.asyncschenarioproducer.service.TransactionService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
@RequestMapping("/transaction")
class TransactionController(
    private val transactionService: TransactionService
) {
    @GetMapping(
        value = ["/all"],
        produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
    )
    fun all(): Flux<Transaction> {
        return transactionService.getAll().delayElements(Duration.ofMillis(100))
    }

    @PostMapping(
        value = ["payment"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun payment(@RequestBody paymentRequestDto: PaymentRequestDto): Mono<PaymentResponseDto> {
        return transactionService.payment(paymentRequestDto);
    }
}