package kristileka.cleanarch.presentation.dto.renter

import io.mockk.mockk
import kristileka.cleanarch.presentation.dto.book.BookREST
import kristileka.cleanarch.presentation.dto.book.BookRESTTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RentedBookRESTTest {
    private val rentedBook = RentedBookREST()
    private val mockedBook = mockk<BookREST>()

    @Test
    fun `test book property`() {
        rentedBook.book = mockedBook
        assertEquals(mockedBook, rentedBook.book)
    }

    @Test
    fun `test bookRentDate property`() {
        val rentDate = LocalDate.of(2022, 1, 1)
        rentedBook.bookRentDate = rentDate
        assertEquals(rentDate, rentedBook.bookRentDate)
    }

    @Test
    fun `test bookReturnDate property`() {
        val returnDate = LocalDate.of(2022, 2, 1)
        rentedBook.bookReturnDate = returnDate
        assertEquals(returnDate, rentedBook.bookReturnDate)
    }
}
