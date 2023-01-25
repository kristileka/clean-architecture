package kristileka.cleanarch.infrastructure.mappers

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toDomain
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toEntity
import kristileka.cleanarch.infrastructure.models.BookEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BookEntityMapperTest {

    @Test
    fun `Test Book from Entity to Domain`() {
        val bookEntity = BookEntity().apply {
            this.id = 1
            this.name = "test"
            this.author = "Author"
            this.quantity = 1
            this.categories = listOf("category1")
        }
        val bookDomain = bookEntity.toDomain()

        assertEquals(bookDomain.id, bookEntity.id)
        assertEquals(bookDomain.name, bookEntity.name)
        assertEquals(bookDomain.author, bookEntity.author)
        assertEquals(bookDomain.quantity, bookEntity.quantity)
        assertEquals(bookDomain.categories, bookEntity.categories)
    }

    @Test
    fun `Test Book from Domain to Entity`() {
        val bookDomain = Book(1, "test", "Author", 1, listOf("category1"))
        val bookEntity = bookDomain.toEntity()

        assertEquals(bookEntity.id, bookDomain.id)
        assertEquals(bookEntity.name, bookDomain.name)
        assertEquals(bookEntity.author, bookDomain.author)
        assertEquals(bookEntity.quantity, bookDomain.quantity)
        assertEquals(bookEntity.categories, bookDomain.categories)
    }
}
