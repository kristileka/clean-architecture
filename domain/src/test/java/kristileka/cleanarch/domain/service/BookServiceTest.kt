package kristileka.cleanarch.domain.service

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.store.IBookStoreAPI
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class BookServiceTest {
    private val bookStoreAPI: IBookStoreAPI = mockk()
    private lateinit var bookService: BookService

    @BeforeEach
    fun init() {
        bookService = BookService(bookStoreAPI)
    }

    @Test
    fun `Get All Books`() {
        val expectedBooks = listOf(
            Book(1L, "Book1", "Author1", 10, listOf("Science", "Fiction")),
            Book(2L, "Book2", "Author2", 5, listOf("Science"))
        )

        every {
            bookStoreAPI.findAll()
        } returns expectedBooks
        val result = bookService.getBooks()
        assertEquals(result.size, expectedBooks.size)
        assertEquals(result.first().name, expectedBooks.first().name)
        assertEquals(result.first().author, expectedBooks.first().author)
        assertEquals(result.first().categories, expectedBooks.first().categories)
    }

    @Test
    fun `Query Books`() {
        val expectedBooks = listOf(
            Book(1L, "Book1", "Author1", 10, listOf("Science", "Fiction")),
            Book(2L, "Book2", "Author2", 5, listOf("Science"))
        )

        every {
            bookStoreAPI.findAllByCategoryAndAuthor("a", "a", "a")
        } returns expectedBooks
        val result = bookService.queryBooks("a", "a", "a")
        assertEquals(result.size, expectedBooks.size)
        assertEquals(result.first().name, expectedBooks.first().name)
        assertEquals(result.first().author, expectedBooks.first().author)
        assertEquals(result.first().categories, expectedBooks.first().categories)
    }

    @Test
    fun `Get Book By Id`() {
        val expectedBook = Book(1L, "Book1", "Author1", 10, listOf("Science", "Fiction"))

        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook
        val result = bookService.getBookById(1)
        assertEquals(result.author, expectedBook.author)
        assertEquals(result.name, expectedBook.name)
        assertEquals(result.quantity, expectedBook.quantity)
        assertEquals(result.categories, expectedBook.categories)
    }

    @Test
    fun `Get Book Availability No Quantity`() {
        val expectedBook = Book(1L, "Book1", "Author1", 0, listOf("Science", "Fiction"))

        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook
        val result = bookService.getBookAvailability(1)
        assertFalse(result)
    }

    @Test
    fun `Get Book Availability Has Quantity`() {
        val expectedBook = Book(1L, "Book1", "Author1", 10, listOf("Science", "Fiction"))

        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook
        val result = bookService.getBookAvailability(1)
        assertTrue(result)
    }

    @Test
    fun `Import Book`() {
        val expectedBook = Book(1L, "Book1", "Author1", 10, listOf("Science", "Fiction"))
        every {
            bookStoreAPI.findBookByName("Book1")
        } returns expectedBook

        every {
            bookStoreAPI.save(expectedBook)
        } returns expectedBook

        val result = bookService.importBook(expectedBook)

        assertEquals(result.quantity, expectedBook.quantity)
    }

    @Test
    fun `Export Book`() {
        val bookId = 1L
        every {
            bookStoreAPI.delete(1)
        } returns true

        val result = bookService.exportBook(bookId)
        assertTrue(result)
    }

}