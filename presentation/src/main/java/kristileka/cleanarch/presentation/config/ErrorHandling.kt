package kristileka.cleanarch.presentation.config

import kristileka.cleanarch.domain.exceptions.BookNotAvailable
import kristileka.cleanarch.domain.exceptions.GeneralExceptions
import kristileka.cleanarch.domain.exceptions.RenterAlreadyHaveBook
import kristileka.cleanarch.domain.exceptions.RenterDoesNotHaveBook
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class ErrorHandling {

    @ExceptionHandler(GeneralExceptions::class)
    fun handleGeneralExceptions(ex: GeneralExceptions, request: WebRequest): ResponseEntity<Any> {
        val body = LinkedHashMap<String, Any>()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = ex.message!!
        return ResponseEntity(body, getStatusCode(ex))
    }

    fun getStatusCode(ex: GeneralExceptions): HttpStatus {
        return when (ex) {
            is BookNotAvailable -> HttpStatus.GONE
            is RenterAlreadyHaveBook -> HttpStatus.CONFLICT
            is RenterDoesNotHaveBook -> HttpStatus.CONFLICT
            else -> HttpStatus.NOT_FOUND
        }
    }
}
