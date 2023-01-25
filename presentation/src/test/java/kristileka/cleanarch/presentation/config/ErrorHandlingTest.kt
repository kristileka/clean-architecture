package kristileka.cleanarch.presentation.config

import io.mockk.mockk
import kristileka.cleanarch.domain.exceptions.BookNotAvailable
import kristileka.cleanarch.domain.exceptions.BookNotFoundException
import kristileka.cleanarch.domain.exceptions.GeneralExceptions
import kristileka.cleanarch.domain.exceptions.RenterAlreadyHaveBook
import kristileka.cleanarch.domain.exceptions.RenterDoesNotHaveBook
import kristileka.cleanarch.domain.exceptions.RenterNotFoundException
import org.junit.jupiter.api.Assertions.*
import  org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest

class ErrorHandlingTest {

    private var webRequest: WebRequest = mockk()

    @Test
    fun handleGeneralExceptions() {
        val errorHandling = ErrorHandling()
        val bookNotFoundException = GeneralExceptions("General")
        val result = errorHandling.handleGeneralExceptions(bookNotFoundException, webRequest)
        assertEquals(result.statusCode, HttpStatus.NOT_FOUND)
    }

    @Test
    fun handleBookNotFound() {
        val errorHandling = ErrorHandling()
        val bookNotFoundException = BookNotFoundException()
        val result = errorHandling.handleGeneralExceptions(bookNotFoundException, webRequest)
        assertEquals(result.statusCode, HttpStatus.NOT_FOUND)
    }

    @Test
    fun handleRenterNotFound() {
        val errorHandling = ErrorHandling()
        val bookNotFoundException = RenterNotFoundException()
        val result = errorHandling.handleGeneralExceptions(bookNotFoundException, webRequest)
        assertEquals(result.statusCode, HttpStatus.NOT_FOUND)
    }

    @Test
    fun handleRenterAlreadyHaveBook() {
        val errorHandling = ErrorHandling()
        val bookNotFoundException = RenterAlreadyHaveBook()
        val result = errorHandling.handleGeneralExceptions(bookNotFoundException, webRequest)
        assertEquals(result.statusCode, HttpStatus.CONFLICT)
    }


    @Test
    fun handleRenterDoesNotHaveBook() {
        val errorHandling = ErrorHandling()
        val bookNotFoundException = RenterDoesNotHaveBook()
        val result = errorHandling.handleGeneralExceptions(bookNotFoundException, webRequest)
        assertEquals(result.statusCode, HttpStatus.CONFLICT)
    }

    @Test
    fun handleBookNotAvailable() {
        val errorHandling = ErrorHandling()
        val bookNotFoundException = BookNotAvailable()
        val result = errorHandling.handleGeneralExceptions(bookNotFoundException, webRequest)
        assertEquals(result.statusCode, HttpStatus.GONE)
    }


    @Test
    fun getStatusCode() {
        val errorHandling = ErrorHandling()
        val bookNotFoundException = BookNotFoundException()
        val result = errorHandling.getStatusCode(bookNotFoundException)
        assertEquals(result, HttpStatus.NOT_FOUND)
    }
}