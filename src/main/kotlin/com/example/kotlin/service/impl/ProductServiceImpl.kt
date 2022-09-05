package com.example.kotlin.service.impl

import com.example.kotlin.entity.Product
import com.example.kotlin.exception.NotFoundException
import com.example.kotlin.model.CreateProductRequest
import com.example.kotlin.model.ProductResponse
import com.example.kotlin.model.UpdateProductRequest
import com.example.kotlin.repository.ProductRepository
import com.example.kotlin.service.ProductService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService{

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        val product = Product(
                id = createProductRequest.id!!,
                name = createProductRequest.name!!,
                price = createProductRequest.price!!,
                quantity = createProductRequest.quantity!!,
                createdDate = LocalDate.now(),
                updatedDate = null
        )

        productRepository.save(product);
        return convertProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id);
        if(product == null){
            throw NotFoundException()
        }else{
            return convertProductResponse(product)
        }
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = productRepository.findByIdOrNull(id) ?: throw NotFoundException()

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedDate = LocalDate.now()
        }

        productRepository.save(product)
        return convertProductResponse(product)
    }

    override fun delete(id: String): Boolean {
        val product = productRepository.findByIdOrNull(id) ?: throw NotFoundException()
        productRepository.delete(product)
        return true
    }

    override fun getAll(): MutableList<Product> {
        val product = productRepository.findAll()
        return product
    }


    private fun convertProductResponse(product: Product) : ProductResponse{
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