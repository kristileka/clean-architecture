package kristileka.cleanarch.infrastructure.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RenterEntityTest {
    @Test
    fun `Test Renter entity class Properties`() {
        val propertyId = "testId"
        val propertyName = "test"
        val bookEntity = RenterEntity().apply {
            this.id = propertyId
            this.name = propertyName
            this.rentedBooks = mutableListOf()
        }
        assertEquals(bookEntity.id, propertyId)
        assertEquals(bookEntity.name, propertyName)
        assertTrue(bookEntity.rentedBooks.isEmpty())
    }
}