package kristileka.cleanarch.application.usecases.renter

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.service.RenterService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RentBookUseCaseTest {
    private val renterService = mockk<RenterService>()
    private val rentBookUseCase = RentBookUseCase(renterService)
    var renter = Renter("", "")
    private val mockedInput = RentBookUseCase.Input(renter, 1L)
    private val mockedOutput = RentBookUseCase.Output(renter)

    @Test
    fun `test invoke method`() {
        every { renterService.rentBook(renter, 1L) } returns mockedOutput.renter
        val output = rentBookUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.renter, output.renter)
    }
}
