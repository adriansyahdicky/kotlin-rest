package com.example.kotlin.controller

import com.example.kotlin.model.*
import com.example.kotlin.service.ProductService
import org.springframework.web.bind.annotation.*
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

    @GetMapping(value = ["/api/products/{idProduct}"],
            produces = ["application/json"])
    fun getProduct(@PathVariable("idProduct") id: String) : WebResponse<ProductResponse>{
        val productResponse =  productService.get(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @PutMapping(value = ["/api/products/{idProduct}"],
            produces = ["application/json"],
            consumes = ["application/json"])
    fun updateProduct(@Valid @RequestBody body: UpdateProductRequest,
                        @PathVariable("idProduct") id: String): WebResponse<ProductResponse>{
        val productResponse = productService.update(id,body)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @DeleteMapping(value = ["/api/products/{idProduct}"],
            produces = ["application/json"],
            consumes = ["application/json"])
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<Boolean>{
        val productResponse = productService.delete(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @GetMapping(value = ["/api/products"],
            produces = ["application/json"])
    fun listProducts(@RequestParam("size", defaultValue = "10") size: Int,
                     @RequestParam("page", defaultValue = "0") page: Int) : WebResponse<List<ProductResponse>>{
        val request = ListProductRequest(page, size)
        val productResponse =  productService.list(request)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

}