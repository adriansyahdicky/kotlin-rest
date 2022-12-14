package com.example.kotlin.service

import com.example.kotlin.model.CreateProductRequest
import com.example.kotlin.model.ListProductRequest
import com.example.kotlin.model.ProductResponse
import com.example.kotlin.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest) : ProductResponse
    fun get(id: String) : ProductResponse
    fun update(id: String, updateProductRequest: UpdateProductRequest) : ProductResponse
    fun delete(id: String) : Boolean
    fun list(listProductRequest: ListProductRequest) : List<ProductResponse>
}