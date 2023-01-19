package kristileka.cleanarch.presentation.controller.book.retrieval

import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.book.*
import kristileka.cleanarch.presentation.dto.book.BookAvailabilityREST
import kristileka.cleanarch.presentation.dto.book.BookREST
import kristileka.cleanarch.presentation.mappers.BookMapper.toREST
import org.springframework.web.bind.annotation.RestController

@RestController
class BookRetrievalController(
    val useCaseInvoker: UseCaseInvoker,
    val queryBooksUseCase: QueryBooksUseCase,
    val getAllBooksUseCase: GetAllBooksUseCase,
    val getBookByIdUseCase: GetBookByIdUseCase,
    val getBookAvailabilityUseCase: GetBookAvailabilityUseCase,
) : BookRetrievalResource {

    override fun getAllBooks(): List<BookREST> {
        return useCaseInvoker.execute(
            getAllBooksUseCase, GetAllBooksUseCase.Input()
        ).books.map { it.toREST() }
    }

    override fun getBookById(bookId: String): BookREST {
        return useCaseInvoker.execute(
            getBookByIdUseCase, GetBookByIdUseCase.Input(bookId.toLong())
        ).book.toREST()
    }

    override fun queryBooks(author: String?, category: String?, name: String?): List<BookREST> {
        return useCaseInvoker.execute(
            queryBooksUseCase, QueryBooksUseCase.Input(category, author, name)
        ).books.map {
            it.toREST()
        }
    }

    override fun getBookAvailability(bookId: String): BookAvailabilityREST {
        return BookAvailabilityREST().apply {
            this.available = useCaseInvoker.execute(
                getBookAvailabilityUseCase, GetBookAvailabilityUseCase.Input(bookId.toLong())
            ).available
        }
    }

}