package com.josep.asyncschenarioproducer.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal

@Table("transaction")
data class Transaction(
    @Id
    val id: Int,
    val invoiceNumber: String,
    val amount: BigDecimal,
    val status: String
)
