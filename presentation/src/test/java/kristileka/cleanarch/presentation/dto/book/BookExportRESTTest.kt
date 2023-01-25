package kristileka.cleanarch.presentation.dto.book

import org.junit.jupiter.api.Assertions.assertTrue
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
