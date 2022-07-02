package com.example.randompasswordgeneratorweb.Handler

import com.example.randompasswordgeneratorweb.Exceptions.InvalidLength
import com.example.randompasswordgeneratorweb.Exceptions.InvalidNumberOfParameters
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(InvalidLength::class)])
    fun InvalidLenght(ex: InvalidLength, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity("The Length Value Was Invalid", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [(InvalidNumberOfParameters::class)])
    fun InvalidNumberOfParameters(ex: InvalidNumberOfParameters, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity("Invalid Number Of Parameters", HttpStatus.BAD_REQUEST)
    }

}