package kristileka.cleanarch.application.usecases.book

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.service.BookService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExportBookUseCaseTest {
    private val mockedBookService = mockk<BookService>()
    private val exportBookUseCase = ExportBookUseCase(mockedBookService)
    private val mockedInput = ExportBookUseCase.Input(1)
    private val mockedOutput = ExportBookUseCase.Output(true)

    @Test
    fun `test invoke method`() {
        every { mockedBookService.exportBook(mockedInput.bookId) } returns mockedOutput.exported
        val output = exportBookUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.exported, output.exported)
    }
}
