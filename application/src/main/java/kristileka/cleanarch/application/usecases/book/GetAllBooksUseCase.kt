package kristileka.cleanarch.application.usecases.book

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.service.BookService
import org.springframework.stereotype.Component

@Component
class GetAllBooksUseCase(
    private val bookService: BookService,
) : UseCase<GetAllBooksUseCase.Input, GetAllBooksUseCase.Output>() {

    class Input : UseCase.Input

    class Output(val books: List<Book>) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(bookService.getBooks())
    }
}
