package com.url.urlzip

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(javaClass)
    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Nothing>> {
        log.info(e.stackTraceToString())

        return ResponseEntity(ApiResponse.fail(e.message ?: "your request failed"), HttpStatus.OK)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<ApiResponse<Nothing>> {
        log.info(e.stackTraceToString())

        return ResponseEntity(ApiResponse.fail("요청이 잘못되었습니다."), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Nothing>> {
        log.info(e.stackTraceToString())

        return ResponseEntity(
            ApiResponse.fail(
                e
                    .bindingResult
                    .allErrors
                    .map {
                        it.defaultMessage
                    }.joinToString("|")
            ),
            HttpStatus.BAD_REQUEST
        )
    }
}
