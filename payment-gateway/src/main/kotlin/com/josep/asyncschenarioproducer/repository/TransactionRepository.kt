package com.josep.asyncschenarioproducer.repository

import com.josep.asyncschenarioproducer.entity.Transaction
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : ReactiveCrudRepository<Transaction, Int> {
}