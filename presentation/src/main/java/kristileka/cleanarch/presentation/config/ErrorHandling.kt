package kristileka.cleanarch.presentation.config

import kristileka.cleanarch.domain.exceptions.BookNotFoundException
import kristileka.cleanarch.domain.exceptions.RenterAlreadyHaveBook
import kristileka.cleanarch.domain.exceptions.RenterDoesNotHaveBook
import kristileka.cleanarch.domain.exceptions.RenterNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime


@ControllerAdvice
class ErrorHandling {

    @ExceptionHandler(BookNotFoundException::class)
    fun handleBookNotFound(ex: BookNotFoundException, request: WebRequest): ResponseEntity<Any> {
        val body = LinkedHashMap<String, Any>()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = ex.message!!
        return ResponseEntity(body, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(RenterNotFoundException::class)
    fun handleRenterNotFound(ex: RenterNotFoundException, request: WebRequest): ResponseEntity<Any> {
        val body = LinkedHashMap<String, Any>()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = ex.message!!
        return ResponseEntity(body, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(RenterDoesNotHaveBook::class)
    fun handleRenterDoesNotHaveBook(ex: RenterDoesNotHaveBook, request: WebRequest): ResponseEntity<Any> {
        val body = LinkedHashMap<String, Any>()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = ex.message!!
        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(RenterAlreadyHaveBook::class)
    fun handleRenterAlreadyHasBook(ex: RenterAlreadyHaveBook, request: WebRequest): ResponseEntity<Any> {
        val body = LinkedHashMap<String, Any>()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = ex.message!!
        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }


}