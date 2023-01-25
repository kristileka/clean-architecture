package kristileka.cleanarch.infrastructure.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BookEntityTest {
    @Test
    fun `Test Book entity class Properties`() {
        val propertyId = 1L
        val propertyName = "test"
        val propertyQuantity = 1
        val propertyAuthor = "testAuthor"
        val propertyCategories = listOf("category1")
        val bookEntity = BookEntity().apply {
            this.id = propertyId
            this.name = propertyName
            this.quantity = propertyQuantity
            this.author = propertyAuthor
            this.categories = propertyCategories
        }
        Assertions.assertEquals(bookEntity.id, propertyId)
        Assertions.assertEquals(bookEntity.name, propertyName)
        Assertions.assertEquals(bookEntity.quantity, propertyQuantity)
        Assertions.assertEquals(bookEntity.author, propertyAuthor)
        Assertions.assertEquals(bookEntity.categories, propertyCategories)
    }
}