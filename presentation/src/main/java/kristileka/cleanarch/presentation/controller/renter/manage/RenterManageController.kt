package kristileka.cleanarch.presentation.controller.renter.manage

import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.renter.GetRenterByIdUseCase
import kristileka.cleanarch.application.usecases.renter.GetAllRentersUseCase
import kristileka.cleanarch.application.usecases.renter.RentBookUseCase
import kristileka.cleanarch.application.usecases.renter.ReturnBookUseCase
import kristileka.cleanarch.presentation.dto.renter.RenterREST
import kristileka.cleanarch.presentation.mappers.RenterMapper.toDomain
import kristileka.cleanarch.presentation.mappers.RenterMapper.toREST
import org.springframework.web.bind.annotation.RestController

@RestController
class RenterManageController(
    val useCaseInvoker: UseCaseInvoker,
    val rentBookUseCase: RentBookUseCase,
    val returnBookUseCase: ReturnBookUseCase
) : RenterManageResource {


    override fun rentBook(bookId: String, renterRest: RenterREST): RenterREST {
        return useCaseInvoker.execute(
            rentBookUseCase, RentBookUseCase.Input(renterRest.toDomain(), bookId.toLong())
        ).renter.toREST()
    }

    override fun returnBook(bookId: String, renterRest: RenterREST): RenterREST {
        return useCaseInvoker.execute(
            returnBookUseCase, ReturnBookUseCase.Input(renterRest.toDomain(), bookId.toLong())
        ).renter.toREST()
    }


}