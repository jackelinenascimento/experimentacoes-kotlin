package org.example.exception

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(PersonNotFoundException::class)
    fun handlePersonNotFoundException(exception: PersonNotFoundException): String {
        return exception.message!!
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(exception: EntityNotFoundException): String {
        return exception.message!!
    }
}