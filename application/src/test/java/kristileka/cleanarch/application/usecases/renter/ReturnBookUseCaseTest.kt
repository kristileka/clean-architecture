package kristileka.cleanarch.application.usecases.renter

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.service.RenterService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReturnBookUseCaseTest {
    private val renterService = mockk<RenterService>()
    private val returnBookUseCase = ReturnBookUseCase(renterService)
    var renter = Renter("", "")
    private val mockedInput = ReturnBookUseCase.Input(renter, 1)
    private val mockedOutput = ReturnBookUseCase.Output(renter)

    @Test
    fun `test invoke method`() {
        every { renterService.returnBook(renter, 1) } returns mockedOutput.renter
        val output = returnBookUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.renter, output.renter)
    }
}