package kristileka.cleanarch.application.usecases.book

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.service.BookService
import org.springframework.stereotype.Component

@Component
class ImportBookUseCase(
    private val bookService: BookService
) : UseCase<ImportBookUseCase.Input, ImportBookUseCase.Output>() {

    class Input(val book: Book) : UseCase.Input

    class Output(val book: Book) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(bookService.importBook(input.book))
    }
}