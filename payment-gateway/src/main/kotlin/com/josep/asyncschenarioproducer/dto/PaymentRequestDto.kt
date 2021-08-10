package com.josep.asyncschenarioproducer.dto

import java.math.BigDecimal

data class PaymentRequestDto(
    val invoiceNumber: String,
    val amount: BigDecimal
)
