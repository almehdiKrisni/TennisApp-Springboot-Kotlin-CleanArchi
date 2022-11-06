package fr.kata.tennis.infra.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.client.HttpClientErrorException.BadRequest

class UserHandler {

    @ControllerAdvice
    class UserControllerAdvice {

        @ExceptionHandler(BadRequest::class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ResponseBody
        fun handleConstraintViolation(exception: BadRequest): ResponseEntity<Error> {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Error(exception.localizedMessage, exception.javaClass.simpleName, emptyList()))
        }

        @ExceptionHandler(HttpMessageNotReadableException::class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ResponseBody
        fun handleBadRequest(exception: HttpMessageNotReadableException): ResponseEntity<Error> {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Error(exception.localizedMessage, exception.javaClass.simpleName, emptyList()))
        }
    }
}