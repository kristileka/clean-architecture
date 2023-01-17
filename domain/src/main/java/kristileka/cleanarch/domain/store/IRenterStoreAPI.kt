package kristileka.cleanarch.domain.store

import kristileka.cleanarch.domain.model.Renter

interface IRenterStoreAPI {
    fun getAllRenters(): List<Renter>
    fun getRenterById(renterId: String): Renter?
    fun save(renter: Renter): Renter
    fun returnBook(bookId: Long, renterId: String): Int?
}