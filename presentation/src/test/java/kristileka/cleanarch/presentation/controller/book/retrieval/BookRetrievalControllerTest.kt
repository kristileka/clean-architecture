import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.book.GetAllBooksUseCase
import kristileka.cleanarch.application.usecases.book.GetBookAvailabilityUseCase
import kristileka.cleanarch.application.usecases.book.GetBookByIdUseCase
import kristileka.cleanarch.application.usecases.book.QueryBooksUseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.presentation.controller.book.retrieval.BookRetrievalController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BookRetrievalControllerTest {

    private val useCaseInvoker = mockk<UseCaseInvoker>()
    private val getAllBooksUseCase = mockk<GetAllBooksUseCase>()
    private val getBookByIdUseCase = mockk<GetBookByIdUseCase>()
    private val getBookAvailabilityUseCase = mockk<GetBookAvailabilityUseCase>()
    private val queryBooksUseCase = mockk<QueryBooksUseCase>()

    private lateinit var controller: BookRetrievalController

    @BeforeEach
    fun init() {
        controller = BookRetrievalController(
            useCaseInvoker,
            queryBooksUseCase,
            getAllBooksUseCase,
            getBookByIdUseCase,
            getBookAvailabilityUseCase,
        )
    }

    @Test
    fun `get all books`() {
        val books = listOf(
            Book(1, "The Catcher in the Rye", "J.D. Salinger", 1),
            Book(2, "To Kill a Mockingbird", "Harper Lee", 1),
        )
        val output = GetAllBooksUseCase.Output(books)
        every {
            useCaseInvoker.execute(getAllBooksUseCase, any())
        } returns output

        val result = controller.getAllBooks()
        assertEquals(result.size, books.size)
        assertEquals(result.first().name, books.first().name)
        assertEquals(result.first().id, books.first().id)
    }

    @Test
    fun `query all books`() {
        val books = listOf(
            Book(1, "The Catcher in the Rye", "J.D. Salinger", 1),
            Book(2, "To Kill a Mockingbird", "Harper Lee", 1),
        )
        val output = QueryBooksUseCase.Output(books)
        every {
            useCaseInvoker.execute(queryBooksUseCase, any())
        } returns output

        val result = controller.queryBooks("a", "a", "a")
        assertEquals(result.size, books.size)
        assertEquals(result.first().name, books.first().name)
        assertEquals(result.first().id, books.first().id)
    }

    @Test
    fun `get book by id`() {
        val book =
            Book(1, "The Catcher in the Rye", "J.D. Salinger", 1)
        val output = GetBookByIdUseCase.Output(book)
        every {
            useCaseInvoker.execute(getBookByIdUseCase, any())
        } returns output

        val result = controller.getBookById("1")
        assertEquals(result.name, book.name)
        assertEquals(result.id, book.id)
    }

    @Test
    fun `get book availability false `() {
        val output = GetBookAvailabilityUseCase.Output(false)
        every {
            useCaseInvoker.execute(getBookAvailabilityUseCase, any())
        } returns output

        val result = controller.getBookAvailability("1")
        assertEquals(result.available, false)
    }

    @Test
    fun `get book availability true `() {
        val output = GetBookAvailabilityUseCase.Output(true)
        every {
            useCaseInvoker.execute(getBookAvailabilityUseCase, any())
        } returns output

        val result = controller.getBookAvailability("1")
        assertEquals(result.available, true)
    }
}
