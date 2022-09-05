package com.example.kotlin.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product(
    @Id
    var id: String,
    var name: String,
    var price: Long,
    var quantity: Int,
    var createdDate: LocalDate,
    var updatedDate: LocalDate?
)