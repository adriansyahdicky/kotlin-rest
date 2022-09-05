//package com.example.kotlin.validation
//
//import org.springframework.stereotype.Component
//import org.springframework.web.bind.MethodArgumentNotValidException
//import javax.validation.Validator
//
//@Component
//class ValidationUtil(val validator: Validator) {
//
//    fun validate(any: Any){
//        val result = validator.validate(any)
//        if(result.size!=0){
//            throw MethodArgumentNotValidException(result)
//        }
//    }
//
//}