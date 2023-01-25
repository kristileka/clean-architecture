package kristileka.cleanarch.domain.model

import kristileka.cleanarch.domain.model.Book
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BookTest {
    private val bookId = 1L
    private val bookName = "Book Name"
    private val bookAuthor = "Book Author"
    private val bookQuantity = 10
    private val bookCategories = listOf("category1", "category2")

    @Test
    fun `Test Book class properties`() {
        val book = Book(bookId, bookName, bookAuthor, bookQuantity, bookCategories)
        assertEquals(bookId, book.id)
        assertEquals(bookName, book.name)
        assertEquals(bookAuthor, book.author)
        assertEquals(bookQuantity, book.quantity)
        assertEquals(bookCategories, book.categories)
    }

    @Test
    fun `Test Book class copy function`() {
        val book = Book(bookId, bookName, bookAuthor, bookQuantity, bookCategories)
        val copiedBook = book.copy(quantity = 20)
        assertEquals(bookId, copiedBook.id)
        assertEquals(bookName, copiedBook.name)
        assertEquals(bookAuthor, copiedBook.author)
        assertEquals(20, copiedBook.quantity)
        assertEquals(bookCategories, copiedBook.categories)
    }
}