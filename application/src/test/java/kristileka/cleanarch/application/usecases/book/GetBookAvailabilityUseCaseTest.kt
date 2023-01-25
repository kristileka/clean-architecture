package kristileka.cleanarch.application.usecases.book

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.service.BookService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GetBookAvailabilityUseCaseTest {
    private val mockedBookService = mockk<BookService>()
    private val getBookAvailabilityUseCase = GetBookAvailabilityUseCase(mockedBookService)
    private val mockedInput = GetBookAvailabilityUseCase.Input(1)
    private val mockedOutput = GetBookAvailabilityUseCase.Output(true)

    @Test
    fun `test invoke method`() {
        every { mockedBookService.getBookAvailability(mockedInput.bookId) } returns mockedOutput.available
        val output = getBookAvailabilityUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.available, output.available)
    }
}