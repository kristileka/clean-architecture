package kristileka.cleanarch.presentation.mappers

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.presentation.dto.renter.RentedBookREST
import kristileka.cleanarch.presentation.dto.renter.RenterREST
import kristileka.cleanarch.presentation.mappers.BookMapper.toREST
import kristileka.cleanarch.presentation.mappers.RenterMapper.toDomain
import kristileka.cleanarch.presentation.mappers.RenterMapper.toREST
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class RenterMapperTest {
    private val renter = Renter(
        "1",
        "John Doe",
        mutableListOf(
            RentedBook(
                Book(1, "n", "n"),
                bookRentDate = LocalDate.of(2022, 1, 1),
                bookReturnDate = LocalDate.of(2022, 2, 1)
            )
        )
    )

    @Test
    fun `test toREST method`() {
        val renterREST = renter.toREST()
        assertEquals(renter.id, renterREST.id)
        assertEquals(renter.name, renterREST.name)
        assertEquals(renter.rentedBooks.size, renterREST.rentedBooks.size)
    }

    @Test
    fun `test toDomain method`() {
        val renterREST = RenterREST().also {
            it.id = renter.id
            it.name = renter.name
            it.rentedBooks = listOf(RentedBookREST().apply {
                this.book = Book(1, "n", "n").toREST()
                this.bookRentDate = LocalDate.of(2022, 1, 1)
                this.bookReturnDate = LocalDate.of(2022, 2, 1)
            })
        }
        val domainRenter = renterREST.toDomain()
        assertEquals(renter.id, domainRenter.id)
        assertEquals(renter.name, domainRenter.name)
        assertEquals(renter.rentedBooks, domainRenter.rentedBooks)
    }
}