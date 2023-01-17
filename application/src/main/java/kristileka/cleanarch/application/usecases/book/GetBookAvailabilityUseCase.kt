package kristileka.cleanarch.application.usecases.book

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.service.BookService
import org.springframework.stereotype.Component

@Component
class GetBookAvailabilityUseCase(
    private val bookService: BookService
) : UseCase<GetBookAvailabilityUseCase.Input, GetBookAvailabilityUseCase.Output>() {

    class Input(val bookId: Long) : UseCase.Input

    class Output(val available: Boolean) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(bookService.getBookAvailability(input.bookId))
    }
}