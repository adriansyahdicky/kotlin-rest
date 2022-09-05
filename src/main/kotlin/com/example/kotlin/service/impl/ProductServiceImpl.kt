package com.example.kotlin.service.impl

import com.example.kotlin.entity.Product
import com.example.kotlin.model.CreateProductRequest
import com.example.kotlin.model.ProductResponse
import com.example.kotlin.repository.ProductRepository
import com.example.kotlin.service.ProductService
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService{

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        //validationUtil.validate(createProductRequest)
        val product = Product(
                id = createProductRequest.id!!,
                name = createProductRequest.name!!,
                price = createProductRequest.price!!,
                quantity = createProductRequest.quantity!!,
                createdDate = LocalDate.now(),
                updatedDate = null
        )

        productRepository.save(product);
        return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdDate = product.createdDate,
                updatedDate = product.updatedDate
        )
    }

}