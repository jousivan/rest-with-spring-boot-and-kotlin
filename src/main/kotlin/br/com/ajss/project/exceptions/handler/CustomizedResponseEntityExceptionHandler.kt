package br.com.ajss.project.exceptions.handler

import br.com.ajss.project.exceptions.ExceptionResponse
import br.com.ajss.project.exceptions.InvalidJwtAuthenticationException
import br.com.ajss.project.exceptions.RequiredObjectIsNullException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(Date(), ex.message, request.getDescription(false))
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(RequiredObjectIsNullException::class)
    fun handleBadRequestException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(Date(), ex.message, request.getDescription(false))
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidJwtAuthenticationException::class)
    fun handleInvalidJwtAuthenticationException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val customMessage = "Autenticação JWT inválida. Verifique suas credenciais."
        val exceptionResponse = ExceptionResponse(Date(), "$customMessage: ${ex.message}", request.getDescription(false))
        return ResponseEntity(exceptionResponse, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(br.com.ajss.project.exceptions.ResourceNotFoundException::class)
    fun ResourceNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(Date(), ex.message, request.getDescription(false))
        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadCredentialsException::class)
    fun handleBadCredentialsException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(Date(), "Bad credentials", request.getDescription(false))
        return ResponseEntity(exceptionResponse, HttpStatus.UNAUTHORIZED)
    }

}