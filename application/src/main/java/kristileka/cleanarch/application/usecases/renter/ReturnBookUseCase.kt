package kristileka.cleanarch.application.usecases.renter

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.service.RenterService
import org.springframework.stereotype.Component


@Component
class ReturnBookUseCase(
    val renterService: RenterService
) :
    UseCase<ReturnBookUseCase.Input, ReturnBookUseCase.Output>() {

    class Input(val renter: Renter, val bookId: Long) : UseCase.Input
    class Output(val renter: Renter) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(renterService.returnBook(input.renter, input.bookId))
    }
}