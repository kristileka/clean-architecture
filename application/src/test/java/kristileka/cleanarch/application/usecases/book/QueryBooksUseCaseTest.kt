package kristileka.cleanarch.application.usecases.book

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.service.BookService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueryBooksUseCaseTest {
    private val mockedBookService = mockk<BookService>()
    private val queryBookUseCase = QueryBooksUseCase(mockedBookService)
    private val mockedInput = QueryBooksUseCase.Input("asd", "asd", "asd")
    private val mockedOutput = QueryBooksUseCase.Output(listOf())

    @Test
    fun `test invoke method`() {
        every { mockedBookService.queryBooks("asd", "asd", "asd") } returns mockedOutput.books
        val output = queryBookUseCase.invoke(mockedInput)

        assertEquals(mockedOutput.books, output.books)
        assertEquals(mockedOutput.books.size, output.books.size)
    }
}