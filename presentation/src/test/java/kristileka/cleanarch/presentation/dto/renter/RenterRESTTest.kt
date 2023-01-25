package kristileka.cleanarch.presentation.dto.renter

import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RenterRESTTest {
    private val renter = RenterREST()
    private val mockedRentedBook = mockk<RentedBookREST>()

    @Test
    fun `test id property`() {
        renter.id = "1"
        assertEquals("1", renter.id)
    }

    @Test
    fun `test name property`() {
        renter.name = "John Doe"
        assertEquals("John Doe", renter.name)
    }

    @Test
    fun `test rentedBooks property`() {
        renter.rentedBooks = listOf(mockedRentedBook)
        assertEquals(listOf(mockedRentedBook), renter.rentedBooks)
    }
}
