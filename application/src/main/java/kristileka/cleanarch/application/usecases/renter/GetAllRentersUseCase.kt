package kristileka.cleanarch.application.usecases.renter

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.service.RenterService
import org.springframework.stereotype.Component


@Component
class GetAllRentersUseCase(
    val renterService: RenterService
) :
    UseCase<GetAllRentersUseCase.Input, GetAllRentersUseCase.Output>() {

    class Input : UseCase.Input
    class Output(val renters: List<Renter>) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(renterService.getAllRenters())
    }
}