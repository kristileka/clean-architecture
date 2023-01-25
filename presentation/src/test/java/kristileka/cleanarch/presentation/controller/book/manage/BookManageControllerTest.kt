package kristileka.cleanarch.presentation.controller.book.manage

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.book.ExportBookUseCase
import kristileka.cleanarch.application.usecases.book.GetAllBooksUseCase
import kristileka.cleanarch.application.usecases.book.GetBookAvailabilityUseCase
import kristileka.cleanarch.application.usecases.book.GetBookByIdUseCase
import kristileka.cleanarch.application.usecases.book.ImportBookUseCase
import kristileka.cleanarch.application.usecases.book.QueryBooksUseCase
import kristileka.cleanarch.application.usecases.renter.ReturnBookUseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.presentation.controller.book.retrieval.BookRetrievalController
import kristileka.cleanarch.presentation.mappers.BookMapper.toREST
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class BookManageControllerTest {


    private val useCaseInvoker = mockk<UseCaseInvoker>()
    private val importBookUseCase = mockk<ImportBookUseCase>()
    private val exportBookUseCase = mockk<ExportBookUseCase>()
    private lateinit var controller: BookManageController

    @BeforeEach
    fun init() {
        controller = BookManageController(
            useCaseInvoker, importBookUseCase, exportBookUseCase,
        )
    }

    @Test
    fun `import book`() {
        val book =
            Book(1, "The Catcher in the Rye", "J.D. Salinger", 1)
        val output = ImportBookUseCase.Output(book)
        every {
            useCaseInvoker.execute(importBookUseCase, any())
        } returns output

        val result = controller.importBook(book.toREST())

        assertEquals(result.id, 1)
        assertEquals(result.name, book.name)
        assertEquals(result.author, book.author)
        assertEquals(result.categories, book.categories)
    }


    @Test
    fun `export book`() {
        val output = ExportBookUseCase.Output(true)
        every {
            useCaseInvoker.execute(exportBookUseCase, any())
        } returns output

        val result = controller.exportBook("1")
        assertEquals(result.exported, true)
    }

}