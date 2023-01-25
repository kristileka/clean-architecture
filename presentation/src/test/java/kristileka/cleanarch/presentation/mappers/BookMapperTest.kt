package kristileka.cleanarch.presentation.mappers

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.presentation.dto.book.BookREST
import kristileka.cleanarch.presentation.mappers.BookMapper.toDomain
import kristileka.cleanarch.presentation.mappers.BookMapper.toREST
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BookMapperTest {
    private val book = Book(
        id = 1,
        name = "The Great Gatsby",
        author = "F. Scott Fitzgerald",
        categories = listOf("Fiction", "Classics")
    )

    @Test
    fun `test toREST method`() {
        val bookREST = book.toREST()
        assertEquals(book.id, bookREST.id)
        assertEquals(book.name, bookREST.name)
        assertEquals(book.author, bookREST.author)
        assertEquals(book.categories, bookREST.categories)
    }

    @Test
    fun `test toDomain method`() {
        val bookREST = BookREST().also {
            it.id = book.id
            it.name = book.name
            it.author = book.author
            it.categories = book.categories
        }
        val domainBook = bookREST.toDomain()
        assertEquals(book.id, domainBook.id)
        assertEquals(book.name, domainBook.name)
        assertEquals(book.author, domainBook.author)
        assertEquals(book.categories, domainBook.categories)
    }
}