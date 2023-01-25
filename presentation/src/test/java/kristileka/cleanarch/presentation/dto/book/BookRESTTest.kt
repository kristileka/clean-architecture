package kristileka.cleanarch.presentation.dto.book

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BookRESTTest {
    private val book = BookREST()

    @Test
    fun `test id property`() {
        book.id = 1
        assertEquals(1, book.id)
    }

    @Test
    fun `test name property`() {
        book.name = "The Great Gatsby"
        assertEquals("The Great Gatsby", book.name)
    }

    @Test
    fun `test author property`() {
        book.author = "F. Scott Fitzgerald"
        assertEquals("F. Scott Fitzgerald", book.author)
    }

    @Test
    fun `test categories property`() {
        book.categories = listOf("Fiction", "Classics")
        assertEquals(listOf("Fiction", "Classics"), book.categories)
    }
}