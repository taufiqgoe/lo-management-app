package id.taufiq.lomanagementapp.controller

import id.taufiq.lomanagementapp.dto.op.MessageResponse
import id.taufiq.lomanagementapp.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandlerController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun notfoundHandler(exception: NotFoundException): MessageResponse {
        return MessageResponse(exception.message)
    }

}
