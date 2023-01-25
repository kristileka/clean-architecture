package kristileka.cleanarch.domain.model

import io.mockk.mockk
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate


class RenterTest {
    private val renterId = "1"
    private val renterName = "John Doe"
    private val rentedBook1 = RentedBook(mockk<Book>(), LocalDate.now(), LocalDate.now().plusDays(15))
    private val rentedBook2 = RentedBook(mockk<Book>(), LocalDate.now(), LocalDate.now().plusDays(30))
    private val rentedBooks = mutableListOf(rentedBook1, rentedBook2)

    @Test
    fun `test Renter class properties`() {
        val renter = Renter(renterId, renterName, rentedBooks)
        assertEquals(renterId, renter.id)
        assertEquals(renterName, renter.name)
        assertEquals(rentedBooks, renter.rentedBooks)
    }

    @Test
    fun `test Renter class copy function`() {
        val renter = Renter(renterId, renterName, rentedBooks)
        val copiedRenter = renter.copy(name = "Jane Doe")
        assertEquals(renterId, copiedRenter.id)
        assertEquals("Jane Doe", copiedRenter.name)
        assertEquals(rentedBooks, copiedRenter.rentedBooks)
    }
}

