package com.example.kotlin.model

import java.time.LocalDate

data class ProductResponse(
        val id: String,
        val name: String,
        val price: Long,
        val quantity: Int,
        val createdDate: LocalDate,
        val updatedDate: LocalDate?
)