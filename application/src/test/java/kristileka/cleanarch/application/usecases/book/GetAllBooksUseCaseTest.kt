package kristileka.cleanarch.application.usecases.book

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.service.BookService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GetAllBooksUseCaseTest {
    private val mockedBookService = mockk<BookService>()
    private val getAllBooksUseCase = GetAllBooksUseCase(mockedBookService)
    private val mockedInput = GetAllBooksUseCase.Input()
    private val mockedOutput = GetAllBooksUseCase.Output(listOf())

    @Test
    fun `test invoke method`() {
        every { mockedBookService.getBooks() } returns mockedOutput.books
        val output = getAllBooksUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.books, output.books)
        assertEquals(mockedOutput.books.size, output.books.size)
    }
}