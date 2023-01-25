package kristileka.cleanarch.infrastructure.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RentedBookEntityTest {
    @Test
    fun `Test Rented Book entity class Properties`() {
        val propertyId = 1L
        val propertyRentDate = LocalDate.now()
        val propertyReturnDate = LocalDate.now()
        val rentedBook = RentedBookEntity().apply {
            this.id = propertyId
            this.rentDate = propertyRentDate
            this.returnDate = propertyReturnDate
        }
        assertEquals(rentedBook.id, propertyId)
        assertEquals(rentedBook.returnDate, propertyReturnDate)
        assertEquals(rentedBook.rentDate, propertyRentDate)
    }
}