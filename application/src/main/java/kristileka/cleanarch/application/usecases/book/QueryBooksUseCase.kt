package kristileka.cleanarch.application.usecases.book

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.service.BookService
import org.springframework.stereotype.Component

@Component
class QueryBooksUseCase(
    private val bookService: BookService
) : UseCase<QueryBooksUseCase.Input, QueryBooksUseCase.Output>() {

    class Input(val category: String?, val author: String?) : UseCase.Input

    class Output(val books: List<Book>) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(bookService.queryBooks(input.category , input.author))
    }
}