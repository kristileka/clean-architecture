package kristileka.cleanarch.application.usecases.renter

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.service.RenterService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GetRenterByIdUseCaseTest {
    private val renterService = mockk<RenterService>()
    private val getRenterByIdUseCase = GetRenterByIdUseCase(renterService)
    private val mockedInput = GetRenterByIdUseCase.Input("asd")
    private val mockedOutput = GetRenterByIdUseCase.Output(Renter("", ""))

    @Test
    fun `test invoke method`() {
        every { renterService.getRenterById("asd") } returns mockedOutput.renter
        val output = getRenterByIdUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.renter, output.renter)
    }
}