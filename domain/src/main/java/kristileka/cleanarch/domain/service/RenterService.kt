package kristileka.cleanarch.domain.service

import kristileka.cleanarch.domain.exceptions.BookNotAvailable
import kristileka.cleanarch.domain.exceptions.BookNotFoundException
import kristileka.cleanarch.domain.exceptions.RenterAlreadyHaveBook
import kristileka.cleanarch.domain.exceptions.RenterDoesNotHaveBook
import kristileka.cleanarch.domain.exceptions.RenterNotFoundException
import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.store.IBookStoreAPI
import kristileka.cleanarch.domain.store.IRenterStoreAPI
import org.springframework.stereotype.Service

@Service
class RenterService(
    private val renterStoreAPI: IRenterStoreAPI,
    private val bookstoreAPI: IBookStoreAPI,
) {
    fun getAllRenters(): List<Renter> {
        return renterStoreAPI.findAll()
    }

    fun getRenterById(renterId: String): Renter {
        return renterStoreAPI.findRenterById(renterId) ?: throw RenterNotFoundException()
    }

    fun rentBook(renter: Renter, bookId: Long): Renter {
        val renterInstance = renterStoreAPI.findRenterById(renter.id!!) ?: renter
        val book = bookstoreAPI.findBookById(bookId) ?: throw BookNotFoundException()
        if (book.quantity < 1) throw BookNotAvailable()
        if (renterInstance.rentedBooks.any { it.book?.id == bookId }) throw RenterAlreadyHaveBook()
        renterInstance.rentedBooks.add(RentedBook(book))
        bookstoreAPI.save(
            book.apply {
                this.quantity = this.quantity - 1
            },
        )
        return renterStoreAPI.save(renterInstance)
    }

    fun returnBook(renter: Renter, bookId: Long): Renter {
        val renterInstance = getRenterById(renter.id!!)
        val book = bookstoreAPI.findBookById(bookId) ?: throw BookNotFoundException()
        if (renterInstance.rentedBooks.none { it.book?.id == bookId }) throw RenterDoesNotHaveBook()
        renterStoreAPI.returnBook(bookId, renter.id.toString())
        bookstoreAPI.save(
            book.apply {
                this.quantity = this.quantity + 1
            },
        )
        return getRenterById(renter.id!!)
    }
}
