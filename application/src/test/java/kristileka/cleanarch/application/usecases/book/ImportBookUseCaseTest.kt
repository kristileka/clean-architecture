package kristileka.cleanarch.application.usecases.book

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.service.BookService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ImportBookUseCaseTest {
    private val mockedBookService = mockk<BookService>()
    private val importBookUseCase = ImportBookUseCase(mockedBookService)
    private val mockedInput = ImportBookUseCase.Input(Book(name = "", author = ""))
    private val mockedOutput = ImportBookUseCase.Output(Book(name = "", author = ""))

    @Test
    fun `test invoke method`() {
        every { mockedBookService.importBook(Book(name = "", author = "")) } returns mockedOutput.book
        val output = importBookUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.book, output.book)
    }
}
