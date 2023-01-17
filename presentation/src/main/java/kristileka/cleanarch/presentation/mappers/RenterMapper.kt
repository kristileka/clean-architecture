package kristileka.cleanarch.presentation.mappers

import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.presentation.dto.renter.RentedBookREST
import kristileka.cleanarch.presentation.dto.renter.RenterREST
import kristileka.cleanarch.presentation.mappers.BookMapper.toDomain
import kristileka.cleanarch.presentation.mappers.BookMapper.toREST

object RenterMapper {
    fun Renter.toREST(): RenterREST {
        return RenterREST().also {
            it.id = this.id
            it.name = this.name
            it.rentedBooks = this.rentedBooks.map { it.toREST() }
        }
    }

    fun RenterREST.toDomain(): Renter {
        return Renter(this.id, this.name, this.rentedBooks.map { it.toDomain() }.toMutableList())
    }

    private fun RentedBook.toREST(): RentedBookREST {
        return RentedBookREST().also {
            it.book = this.book?.toREST()
            it.bookRentDate = this.bookRentDate
            it.bookReturnDate = this.bookReturnDate
        }
    }

    private fun RentedBookREST.toDomain(): RentedBook {
        return RentedBook(this.book?.toDomain(), this.bookRentDate, this.bookReturnDate)
    }
}
