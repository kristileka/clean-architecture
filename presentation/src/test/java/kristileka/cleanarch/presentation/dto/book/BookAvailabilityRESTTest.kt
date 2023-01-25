package kristileka.cleanarch.presentation.dto.book

import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BookAvailabilityRESTTest {
    private val bookAvailabilityREST = BookAvailabilityREST()

    @Test
    fun `test available property`() {
        bookAvailabilityREST.available = true
        assertEquals(bookAvailabilityREST.available,true)
    }
}