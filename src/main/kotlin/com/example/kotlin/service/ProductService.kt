package com.example.kotlin.service

import com.example.kotlin.model.CreateProductRequest
import com.example.kotlin.model.ProductResponse

interface ProductService {
    fun create(createProductRequest: CreateProductRequest) : ProductResponse
}