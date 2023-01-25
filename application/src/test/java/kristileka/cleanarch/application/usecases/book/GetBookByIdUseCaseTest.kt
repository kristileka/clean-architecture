package kristileka.cleanarch.application.usecases.book

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.service.BookService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetBookByIdUseCaseTest {
    private val mockedBookService = mockk<BookService>()
    private val getBookUseCaseById = GetBookByIdUseCase(mockedBookService)
    private val mockedInput = GetBookByIdUseCase.Input(1)
    private val mockedOutput = GetBookByIdUseCase.Output(Book(name = "", author = ""))

    @Test
    fun `test invoke method`() {
        every { mockedBookService.getBookById(mockedInput.bookId) } returns mockedOutput.book
        val output = getBookUseCaseById.invoke(mockedInput)

        assertEquals(mockedOutput.book, output.book)
    }
}
