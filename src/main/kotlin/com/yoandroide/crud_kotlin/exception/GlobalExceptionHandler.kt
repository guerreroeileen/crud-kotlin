package com.yoandroide.crud_kotlin.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        ex: ResourceNotFoundException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val errorDetails = ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.message ?: "Resource not found")
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }
}