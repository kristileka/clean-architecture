package kristileka.cleanarch.infrastructure.mappers

import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.infrastructure.mappers.RenterEntityMapper.toDomain
import kristileka.cleanarch.infrastructure.mappers.RenterEntityMapper.toEntity
import kristileka.cleanarch.infrastructure.models.RentedBookEntity
import kristileka.cleanarch.infrastructure.models.RenterEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class RenterEntityMapperTest {

    @Test
    fun `Test Renter from Domain to Entity`() {
        val renterDomain = Renter(
            "test1",
            "test2",
            mutableListOf(),
        )
        val renterEntity = renterDomain.toEntity()
        assertEquals(renterEntity.id, renterDomain.id)
        assertEquals(renterEntity.name, renterDomain.name)
        assertEquals(renterEntity.rentedBooks.size, renterDomain.rentedBooks.size)
    }

    @Test
    fun `Test Renter from Entity to Domain`() {
        val renterEntity = RenterEntity().apply {
            this.id = "test1"
            this.name = "test2"
            this.rentedBooks = mutableListOf()
        }
        val renterDomain = renterEntity.toDomain()
        assertEquals(renterDomain.id, renterEntity.id)
        assertEquals(renterDomain.name, renterEntity.name)
        assertEquals(renterDomain.rentedBooks.size, renterEntity.rentedBooks.size)
    }

    @Test
    fun `Test RentedBook from Domain to Entity`() {
        val rentedBookDomain = RentedBook(null, LocalDate.now(), LocalDate.now())
        val rentedBookEntity = rentedBookDomain.toEntity()
        assertEquals(rentedBookDomain.bookRentDate, rentedBookEntity.rentDate)
        assertEquals(rentedBookDomain.bookReturnDate, rentedBookEntity.returnDate)
    }

    @Test
    fun `Test RentedBook from Entity to Domain`() {
        val rentedBookDomain = RentedBookEntity().apply {
            this.id = 1
            this.book = null
            this.rentDate = LocalDate.now()
            this.returnDate = LocalDate.now()
        }
        val rentedBookEntity = rentedBookDomain.toDomain()
        assertEquals(rentedBookEntity.bookRentDate, rentedBookEntity.bookRentDate)
        assertEquals(rentedBookEntity.bookReturnDate, rentedBookEntity.bookReturnDate)
    }
}
