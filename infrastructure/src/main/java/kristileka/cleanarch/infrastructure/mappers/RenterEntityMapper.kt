package kristileka.cleanarch.infrastructure.mappers

import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toDomain
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toEntity
import kristileka.cleanarch.infrastructure.models.RentedBookEntity
import kristileka.cleanarch.infrastructure.models.RenterEntity

object RenterEntityMapper {
    fun RenterEntity.toDomain(): Renter {
        return Renter(this.id, this.name, this.rentedBooks.map { it.toDomain() }.toMutableList())
    }

    fun Renter.toEntity(): RenterEntity {
        return RenterEntity().also {
            it.id = this.id
            it.name = this.name
            it.rentedBooks = this.rentedBooks.map { it.toEntity() }.toMutableList()
        }
    }

    fun RentedBook.toEntity(): RentedBookEntity {
        return RentedBookEntity().also {
            it.book = this.book?.toEntity()
            it.rentDate = this.bookRentDate
            it.returnDate = this.bookReturnDate
        }
    }

    fun RentedBookEntity.toDomain(): RentedBook {
        return RentedBook(this.book?.toDomain(), this.returnDate, this.rentDate)
    }


}