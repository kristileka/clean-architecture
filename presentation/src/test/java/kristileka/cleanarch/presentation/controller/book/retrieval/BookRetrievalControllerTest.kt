import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.base.impl.UseCaseInvokerImpl
import kristileka.cleanarch.application.usecases.book.GetAllBooksUseCase
import kristileka.cleanarch.application.usecases.book.GetBookAvailabilityUseCase
import kristileka.cleanarch.application.usecases.book.GetBookByIdUseCase
import kristileka.cleanarch.application.usecases.book.QueryBooksUseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.presentation.controller.book.retrieval.BookRetrievalController
import kristileka.cleanarch.presentation.dto.book.BookREST
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class BookRetrievalControllerTest {


    private val useCaseInvoker = Mockito.mock(UseCaseInvoker::class.java)
    private val getAllBooksUseCase = Mockito.mock(GetAllBooksUseCase::class.java)
    private val getBookByIdUseCase = Mockito.mock(GetBookByIdUseCase::class.java)
    private val getBookAvailabilityUseCase = Mockito.mock(GetBookAvailabilityUseCase::class.java)
    private val queryBooksUseCase: QueryBooksUseCase = Mockito.mock(QueryBooksUseCase::class.java)
    @Test
    fun `get all books`() {
        val books = listOf(
            Book(1, "The Catcher in the Rye", "J.D. Salinger", 1), Book(2, "To Kill a Mockingbird", "Harper Lee", 1)
        )
        var input = QueryBooksUseCase.Input("J.D. Salinger", "Novel", null)
        Mockito.`when`(
            useCaseInvoker.execute(queryBooksUseCase,input )
        ).thenReturn(QueryBooksUseCase.Output(books))

        val controller = BookRetrievalController(
            useCaseInvoker, queryBooksUseCase, getAllBooksUseCase, getBookByIdUseCase, getBookAvailabilityUseCase
        )
        val result = controller.queryBooks("J.D. Salinger", "Novel", null)
        assertEquals(result.size, books.size)
        assertEquals(result.first().name, books.first().name)
        assertEquals(result.first().id, books.first().id)
    }
}