package kristileka.cleanarch.infrastructure.store

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.infrastructure.models.BookEntity
import kristileka.cleanarch.infrastructure.repository.BookRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import java.util.*

class BookStoreAPITest {

    @Mock
    private var bookRepository: BookRepository = Mockito.mock(BookRepository::class.java)
    lateinit var bookStoreAPI: BookStoreAPI

    @BeforeEach
    fun init() {
        bookStoreAPI = BookStoreAPI(bookRepository)
    }

    @Test
    fun `Find All Books`() {
        val books = listOf(BookEntity(), BookEntity())
        Mockito.`when`(bookRepository.findAll()).thenReturn(books)
        val result = bookStoreAPI.findAll()
        Assertions.assertEquals(books.size, result.size)
    }

    @Test
    fun `Find Book by Id`() {
        val book = BookEntity().apply {
            this.id = 1
        }
        Mockito.`when`(bookRepository.findById(1)).thenReturn(Optional.of(book))
        val result = bookStoreAPI.findBookById(1)
        Assertions.assertNotNull(book)
        Assertions.assertEquals(book.id, result?.id)
    }

    @Test
    fun `Find Book by Name`() {
        val book = BookEntity().apply {
            this.id = 1
            this.name = "test"
        }
        Mockito.`when`(bookRepository.findByName("test")).thenReturn(book)
        val result = bookStoreAPI.findBookByName("test")
        Assertions.assertNotNull(book)
        Assertions.assertEquals(book.id, result?.id)
    }

    @Test
    fun `Save Book`() {
        val bookEntity = BookEntity().apply {
            this.id = 1
            this.name = "test"
        }
        val bookDomain = Book(1, "test", "test")
        Mockito.`when`(bookRepository.save(any())).thenReturn(bookEntity)
        val result = bookStoreAPI.save(bookDomain)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(bookDomain.id, result.id)
        Assertions.assertEquals(bookEntity.id, result.id)
    }

    @Test
    fun `Delete Book`() {
        val bookEntity = BookEntity().apply {
            this.id = 1
            this.name = "test"
        }
        Mockito.`when`(bookRepository.delete(bookEntity)).then { }
        val result = bookStoreAPI.delete(1)
        Assertions.assertTrue(result)
    }

    @Test
    fun findAllByCategoryAndAuthor() {
        val books = listOf(BookEntity().apply {
            this.id = 1
            this.name = "test"
        })
        Mockito.`when`(bookRepository.findByCategoryAndAuthorAndName("test", "", "")).thenReturn(books)
        val result = bookStoreAPI.findAllByCategoryAndAuthor("test", "", "")
        Assertions.assertEquals(books.size, result.size)
        Assertions.assertEquals(books.first().id, result.first().id)
    }

}