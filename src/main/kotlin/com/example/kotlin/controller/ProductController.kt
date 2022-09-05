package com.example.kotlin.controller

import com.example.kotlin.model.CreateProductRequest
import com.example.kotlin.model.ProductResponse
import com.example.kotlin.model.WebResponse
import com.example.kotlin.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class ProductController(val productService: ProductService){

    @PostMapping(value = ["/api/products"],
                 produces = ["application/json"],
                 consumes = ["application/json"])
    fun createProduct(@Valid @RequestBody body: CreateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productService.create(body)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

}