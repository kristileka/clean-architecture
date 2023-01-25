package kristileka.cleanarch.domain.store

import kristileka.cleanarch.domain.model.Renter

interface IRenterStoreAPI {
    fun findAll(): List<Renter>
    fun findRenterById(renterId: String): Renter?
    fun save(renter: Renter): Renter
    fun returnBook(bookId: Long, renterId: String): Int?
}
