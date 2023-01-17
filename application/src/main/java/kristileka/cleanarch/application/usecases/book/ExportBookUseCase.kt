package kristileka.cleanarch.application.usecases.book

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.service.BookService
import org.springframework.stereotype.Component

@Component
class ExportBookUseCase(
    private val bookService: BookService
) : UseCase<ExportBookUseCase.Input, ExportBookUseCase.Output>() {

    class Input(val bookId: Long) : UseCase.Input

    class Output(val exported: Boolean) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(bookService.exportBook(input.bookId))
    }
}