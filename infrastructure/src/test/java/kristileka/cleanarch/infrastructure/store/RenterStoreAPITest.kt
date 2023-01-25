package kristileka.cleanarch.infrastructure.store

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.infrastructure.models.BookEntity
import kristileka.cleanarch.infrastructure.models.RenterEntity
import kristileka.cleanarch.infrastructure.repository.BookRepository
import kristileka.cleanarch.infrastructure.repository.RenterRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito

internal class RenterStoreAPITest {

    @Mock
    private var renterRepository: RenterRepository = Mockito.mock(RenterRepository::class.java)
    lateinit var renterStoreAPI: RenterStoreAPI

    @BeforeEach
    fun init() {
        renterStoreAPI = RenterStoreAPI(renterRepository)
    }

    @Test
    fun `Find All Renters`() {
        val renters = listOf(RenterEntity(), RenterEntity())
        Mockito.`when`(renterRepository.findAll()).thenReturn(renters)
        val result = renterStoreAPI.findAll()
        Assertions.assertEquals(renters.size, result.size)
    }

    @Test
    fun `Find Renter By Id`() {
        val renter = RenterEntity().apply {
            this.id = "1"
            this.name = "asd"
        }
        Mockito.`when`(renterRepository.findById("1")).thenReturn(renter)
        val result = renterStoreAPI.findRenterById("1")
        Assertions.assertEquals(result?.id, renter.id)
        Assertions.assertEquals(result?.name, renter.name)
    }

    @Test
    fun `Save Renter`() {
        val renterEntity = RenterEntity().apply {
            this.id = "asd"
            this.name = "test"
        }
        val renterDomain = Renter("asd", "test")
        Mockito.`when`(renterRepository.save(ArgumentMatchers.any())).thenReturn(renterEntity)
        val result = renterStoreAPI.save(renterDomain)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(renterDomain.id, result.id)
        Assertions.assertEquals(renterEntity.id, result.id)
    }

    @Test
    fun `Return Book from Renter`() {
        Mockito.`when`(renterRepository.returnBook(1, "a")).thenReturn(1)
        val result = renterStoreAPI.returnBook(1, "a")
        Assertions.assertNotNull(result)
        Assertions.assertEquals(result, 1)
    }
}