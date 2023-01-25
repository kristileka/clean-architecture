package kristileka.cleanarch.application.usecases.renter

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.service.RenterService
import org.springframework.stereotype.Component

@Component
class RentBookUseCase(
    val renterService: RenterService,
) :
    UseCase<RentBookUseCase.Input, RentBookUseCase.Output>() {

    class Input(val renter: Renter, val bookId: Long) : UseCase.Input
    class Output(val renter: Renter) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(renterService.rentBook(input.renter, input.bookId))
    }
}
