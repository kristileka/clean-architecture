package kristileka.cleanarch.infrastructure.datasource

import kristileka.cleanarch.infrastructure.models.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.awt.print.Book

@Repository
interface BookRepository : JpaRepository<BookEntity, Long> {
    override fun findAll(): List<BookEntity>

    @Query(
        value = """SELECT b.*
FROM book b
         JOIN book_categories bc ON b.id = bc.book_id
  AND LOWER(bc.categories) LIKE LOWER(concat('%', ?1, '%'))
  WHERE LOWER(b.author) LIKE LOWER(concat('%', ?2, '%'))
  and LOWER(b.name) LIKE LOWER(concat('%',?3,'%'));
""", nativeQuery = true
    )
    fun findByCategoryAndAuthorAndName(category: String, author: String, name: String): List<BookEntity>
    fun findByName(name: String): BookEntity?
}