package kristileka.cleanarch.application.usecases.renter

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.service.RenterService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GetAllRentersUseCaseTest {
    private val renterService = mockk<RenterService>()
    private val exportBookUseCase = GetAllRentersUseCase(renterService)
    private val mockedInput = GetAllRentersUseCase.Input()
    private val mockedOutput = GetAllRentersUseCase.Output(listOf())

    @Test
    fun `test invoke method`() {
        every { renterService.getAllRenters() } returns mockedOutput.renters
        val output = exportBookUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.renters, output.renters)
    }
}