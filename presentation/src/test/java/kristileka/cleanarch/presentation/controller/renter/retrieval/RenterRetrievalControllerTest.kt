package kristileka.cleanarch.presentation.controller.renter.retrieval

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.application.base.UseCaseInvoker
import kristileka.cleanarch.application.usecases.renter.GetAllRentersUseCase
import kristileka.cleanarch.application.usecases.renter.GetRenterByIdUseCase
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RenterRetrievalControllerTest {

    private val useCaseInvoker = mockk<UseCaseInvoker>()
    private val getAllRentersUseCase = mockk<GetAllRentersUseCase>()
    private val getRenterByIdUseCase = mockk<GetRenterByIdUseCase>()
    private lateinit var controller: RenterRetrievalController

    @BeforeEach
    fun init() {
        controller = RenterRetrievalController(
            useCaseInvoker,
            getAllRentersUseCase,
            getRenterByIdUseCase,
        )
    }

    @Test
    fun getAllRenters() {
        val renter =
            listOf(Renter("asdasdasd", "asdasd", rentedBooks = mutableListOf(RentedBook(Book(1, "", "")))))
        val output = GetAllRentersUseCase.Output(renter)
        every {
            useCaseInvoker.execute(getAllRentersUseCase, any())
        } returns output

        val controller = RenterRetrievalController(
            useCaseInvoker,
            getAllRentersUseCase,
            getRenterByIdUseCase,
        )

        val result = controller.getAllRenters()

        assertEquals(result.first().id, renter.first().id)
        assertEquals(result.first().name, renter.first().name)
        assertTrue(result.first().rentedBooks.isNotEmpty())
    }

    @Test
    fun getRenterById() {
        val renter =
            Renter("asdasdasd", "asdasd", rentedBooks = mutableListOf(RentedBook(Book(1, "", ""))))
        val output = GetRenterByIdUseCase.Output(renter)
        every {
            useCaseInvoker.execute(getRenterByIdUseCase, any())
        } returns output

        val result = controller.getRenterById("1")

        assertEquals(result.id, renter.id)
        assertEquals(result.name, renter.name)
        assertTrue(result.rentedBooks.isNotEmpty())
    }
}
