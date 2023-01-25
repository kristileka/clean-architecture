package kristileka.cleanarch.domain.model

import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RentedBookTest {
    private val book = mockk<Book>()
    private val rentDate = LocalDate.now()
    private val returnDate = LocalDate.now().plusDays(15)

    @Test
    fun `Test RentedBook class properties`() {
        val rentedBook = RentedBook(book, rentDate, returnDate)
        assertEquals(book, rentedBook.book)
        assertEquals(rentDate, rentedBook.bookRentDate)
        assertEquals(returnDate, rentedBook.bookReturnDate)
    }

    @Test
    fun `Test RentedBook class copy function`() {
        val rentedBook = RentedBook(book, rentDate, returnDate)
        val copiedRentedBook = rentedBook.copy(bookReturnDate = LocalDate.now().plusDays(30))
        assertEquals(book, copiedRentedBook.book)
        assertEquals(rentDate, copiedRentedBook.bookRentDate)
        assertEquals(LocalDate.now().plusDays(30), copiedRentedBook.bookReturnDate)
    }
}
