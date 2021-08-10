package com.josep.asyncschenarioproducer.dto

import java.math.BigDecimal

data class PaymentResponseDto(
    val id: Int,
    val invoiceNumber: String,
    val amount: BigDecimal
)
