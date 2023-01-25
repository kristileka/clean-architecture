package kristileka.cleanarch.infrastructure.repository

import kristileka.cleanarch.infrastructure.models.RenterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import javax.transaction.Transactional

interface RenterRepository : JpaRepository<RenterEntity, Long> {
    fun findById(id: String): RenterEntity?

    @Modifying
    @Query(
        """DELETE from rented_book
where book_id = ?1
and renter_id = ?2
            """,
        nativeQuery = true,
    )
    @Transactional
    fun returnBook(bookId: Long, renterId: String): Int?
}
