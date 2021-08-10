package com.josep.asyncschenarioproducer.service

import com.josep.asyncschenarioproducer.dto.PaymentRequestDto
import com.josep.asyncschenarioproducer.dto.PaymentResponseDto
import com.josep.asyncschenarioproducer.entity.Transaction
import com.josep.asyncschenarioproducer.exception.GeneralException
import com.josep.asyncschenarioproducer.repository.TransactionRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigDecimal

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository
) {
    fun getAll(): Flux<Transaction> {
        return transactionRepository.findAll();
    }

    fun initTransaction(invoiceNumber: String, amount: BigDecimal): Mono<Transaction> {
        var transaction = Transaction(
            0,
            invoiceNumber,
            amount,
            "INITIAL"
        );
        return transactionRepository.save(transaction);
    }

    fun payment(paymentRequestDto: PaymentRequestDto): Mono<PaymentResponseDto> {
        return initTransaction(
            paymentRequestDto.invoiceNumber,
            paymentRequestDto.amount
        ).flatMap { transaction -> transactionToPaymentResponseDto(transaction) }
    }

    fun transactionToPaymentResponseDto(transaction: Transaction): Mono<PaymentResponseDto> {
        return Mono.just(PaymentResponseDto(
            transaction.id,
            transaction.invoiceNumber,
            transaction.amount
        ))
    }
}