package kristileka.cleanarch.presentation.controller.renter.retrieval

import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.renter.GetAllRentersUseCase
import kristileka.cleanarch.application.usecases.renter.GetRenterByIdUseCase
import kristileka.cleanarch.presentation.dto.renter.RenterREST
import kristileka.cleanarch.presentation.mappers.RenterMapper.toREST
import org.springframework.web.bind.annotation.RestController

@RestController
class RenterRetrievalController(
    val useCaseInvoker: UseCaseInvoker,
    val getAllRentersUseCase: GetAllRentersUseCase,
    val getRenterByIdUseCase: GetRenterByIdUseCase,
) : RenterRetrievalResource {

    override fun getAllRenters(): List<RenterREST> {
        return useCaseInvoker.execute(
            getAllRentersUseCase,
            GetAllRentersUseCase.Input(),
        ).renters.map { it.toREST() }
    }

    override fun getRenterById(renterId: String): RenterREST {
        return useCaseInvoker.execute(
            getRenterByIdUseCase,
            GetRenterByIdUseCase.Input(renterId),
        ).renter.toREST()
    }
}
