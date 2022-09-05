package com.example.kotlin.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateProductRequest(
        @field:NotBlank(message = "Name Cannot Required")
        val name: String?,
        @field:NotNull(message = "Price Cannot Required")
        @field:Min(message = "Min Price 10", value = 10)
        val price: Long?,
        @field:NotNull(message = "Quantity Cannot Required")
        @field:Min(message = "Min QTY 0", value = 0)
        val quantity: Int?
)