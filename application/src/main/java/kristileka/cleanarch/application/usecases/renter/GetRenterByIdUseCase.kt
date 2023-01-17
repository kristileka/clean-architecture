package kristileka.cleanarch.application.usecases.renter

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.service.RenterService
import org.springframework.stereotype.Component


@Component
class GetRenterByIdUseCase(
    val renterService: RenterService
) :
    UseCase<GetRenterByIdUseCase.Input, GetRenterByIdUseCase.Output>() {

    class Input(val renterId: String) : UseCase.Input
    class Output(val renter: Renter) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(renterService.getRenterById(input.renterId))
    }
}