package kristileka.cleanarch.application.usecases.book

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.service.BookService
import org.springframework.stereotype.Component


@Component
class GetBookByIdUseCase(
    val bookService: BookService
) :
    UseCase<GetBookByIdUseCase.Input, GetBookByIdUseCase.Output>() {

    class Input(val bookId: Long) : UseCase.Input
    class Output(val book: Book) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(bookService.getBookById(input.bookId))
    }
}