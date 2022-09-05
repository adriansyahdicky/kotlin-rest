package com.example.kotlin.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product(
    @Id
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val createdDate: LocalDate,
    val updatedDate: LocalDate?
)