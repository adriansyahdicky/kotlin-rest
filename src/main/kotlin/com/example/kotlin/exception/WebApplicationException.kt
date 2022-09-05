package com.example.kotlin.exception

import com.example.kotlin.model.WebResponse
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.function.Consumer

@RestControllerAdvice
class WebApplicationException {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun validationHandler(ex: MethodArgumentNotValidException) : WebResponse<MutableMap<String, String?>> {
        val errorMap: MutableMap<String, String?> = HashMap()
        ex.bindingResult.fieldErrors
                .forEach(Consumer { fieldError: FieldError ->
                    errorMap[fieldError.field] = fieldError.defaultMessage
                })
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = errorMap
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun validationNotFound(ex: NotFoundException) : WebResponse<String>{
        return WebResponse(
                code = 404,
                status = "NOT FOUND",
                data = "Not Found"
        )
    }

}