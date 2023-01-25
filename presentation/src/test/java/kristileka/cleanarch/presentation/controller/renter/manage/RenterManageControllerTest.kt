package kristileka.cleanarch.presentation.controller.renter.manage

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.book.ImportBookUseCase
import kristileka.cleanarch.application.usecases.renter.RentBookUseCase
import kristileka.cleanarch.application.usecases.renter.ReturnBookUseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.presentation.controller.book.manage.BookManageController
import kristileka.cleanarch.presentation.mappers.BookMapper.toREST
import kristileka.cleanarch.presentation.mappers.RenterMapper.toREST
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test

internal class RenterManageControllerTest {
    private val useCaseInvoker = mockk<UseCaseInvoker>()
    private val rentBookUseCase = mockk<RentBookUseCase>()
    private val returnBookUseCase = mockk<ReturnBookUseCase>()

    private lateinit var controller: RenterManageController

    @BeforeEach
    fun init() {
        controller = RenterManageController(
            useCaseInvoker, rentBookUseCase, returnBookUseCase,
        )
    }

    @Test
    fun rentBook() {
        val renter = Renter("asdasdasd", "asdasd", rentedBooks = mutableListOf(RentedBook(Book(1, "", ""))))
        val output = RentBookUseCase.Output(renter)
        every {
            useCaseInvoker.execute(rentBookUseCase, any())
        } returns output

        val result = controller.rentBook("1", renter.toREST())

        Assertions.assertEquals(result.id, renter.id)
        Assertions.assertEquals(result.name, renter.name)
        Assertions.assertTrue(result.rentedBooks.isNotEmpty())
    }

    @Test
    fun returnBook() {
        val renter = Renter("asdasdasd", "asdasd")
        val output = ReturnBookUseCase.Output(renter)
        every {
            useCaseInvoker.execute(returnBookUseCase, any())
        } returns output

        val result = controller.returnBook("1", renter.toREST())

        Assertions.assertEquals(result.id, renter.id)
        Assertions.assertEquals(result.name, renter.name)
        Assertions.assertTrue(result.rentedBooks.isEmpty())
    }
}