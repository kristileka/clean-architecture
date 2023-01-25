package kristileka.cleanarch.presentation.dto.book

import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BookExportRESTTest {
    private val bookExportREST = BookExportREST()

    @Test
    @Suppress("KotlinConstantConditions")
    fun `test available property`() {
        bookExportREST.exported = true
        assertTrue(bookExportREST.exported)
    }
}