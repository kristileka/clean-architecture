package kristileka.cleanarch.domain.service

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.domain.exceptions.BookNotAvailable
import kristileka.cleanarch.domain.exceptions.BookNotFoundException
import kristileka.cleanarch.domain.exceptions.RenterAlreadyHaveBook
import kristileka.cleanarch.domain.exceptions.RenterDoesNotHaveBook
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.model.RentedBook
import kristileka.cleanarch.domain.model.Renter
import kristileka.cleanarch.domain.store.IBookStoreAPI
import kristileka.cleanarch.domain.store.IRenterStoreAPI
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RenterServiceTest {
    private val renterStoreAPI: IRenterStoreAPI = mockk<IRenterStoreAPI>()
    private val bookStoreAPI: IBookStoreAPI = mockk<IBookStoreAPI>()

    private lateinit var renterService: RenterService

    @BeforeEach
    fun init() {
        renterService = RenterService(renterStoreAPI, bookStoreAPI)
    }

    @Test
    fun `Get All Renters`() {
        val expectedRenters = listOf(
            Renter("asd", "Renter", mutableListOf(mockk<RentedBook>())),
            Renter("ads", "Renter", mutableListOf(mockk<RentedBook>())),
        )

        every {
            renterStoreAPI.findAll()
        } returns expectedRenters
        val result = renterService.getAllRenters()
        assertEquals(result.size, expectedRenters.size)
        assertEquals(result.first().name, expectedRenters.first().name)
        assertEquals(result.first().id, expectedRenters.first().id)
        assertEquals(result.first().rentedBooks, expectedRenters.first().rentedBooks)
    }

    @Test
    fun `Get Renter By Id`() {
        val expectedRenter = Renter("asd", "Renter1", mutableListOf(mockk<RentedBook>()))

        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter

        val result = renterService.getRenterById("test")
        assertEquals(result.name, expectedRenter.name)
        assertEquals(result.id, expectedRenter.id)
        assertEquals(result.rentedBooks, expectedRenter.rentedBooks)
    }

    @Test
    fun `Rent Book Error Book Not Found`() {
        val expectedRenter = Renter("test", "Renter1", mutableListOf(mockk<RentedBook>()))
        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter

        every {
            bookStoreAPI.findBookById(1)
        } returns null

        assertThrows(BookNotFoundException::class.java) {
            renterService.rentBook(expectedRenter, 1)
        }
    }

    @Test
    fun `Rent Book Error Book Not Available`() {
        val expectedRenter = Renter("test", "Renter1", mutableListOf(mockk<RentedBook>()))
        val expectedBook = Book(1, "asd", "asd", 0)

        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter

        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook

        assertThrows(BookNotAvailable::class.java) {
            renterService.rentBook(expectedRenter, 1)
        }
    }

    @Test
    fun `Rent Book Error Already have book`() {
        val expectedRenter = Renter(
            "test",
            "Renter1",
            mutableListOf(
                RentedBook(
                    Book(1, "asd", "asd", 1),
                ),
            ),
        )
        val expectedBook = Book(1, "asd", "asd", 1)

        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter
        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook
        assertThrows(RenterAlreadyHaveBook::class.java) { renterService.rentBook(expectedRenter, 1) }
    }

    @Test
    fun `Rent Book Success`() {
        val expectedRenter = Renter(
            "test",
            "Renter1",
            mutableListOf(
                RentedBook(
                    Book(2, "asd", "asd", 1),
                ),
            ),
        )
        val expectedBook = Book(1, "asd", "asd", 1)

        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter

        every {
            renterStoreAPI.save(expectedRenter)
        } returns expectedRenter

        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook
        every {
            bookStoreAPI.save(expectedBook)
        } returns expectedBook
        val result = renterService.rentBook(expectedRenter, 1)
        assertEquals(expectedRenter.id, result.id)
        assertEquals(expectedRenter.name, result.name)
    }

    @Test
    fun `Return Book Error Book Not found`() {
        val expectedRenter = Renter("test", "Renter1", mutableListOf(mockk<RentedBook>()))

        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter

        every {
            bookStoreAPI.findBookById(1)
        } returns null

        assertThrows(BookNotFoundException::class.java) {
            renterService.returnBook(expectedRenter, 1)
        }
    }

    @Test
    fun `Return Book Error Renter Doesn't Have Book`() {
        val expectedRenter = Renter(
            "test",
            "Renter1",
            mutableListOf(
                RentedBook(
                    Book(2, "asd", "asd", 1),
                ),
            ),
        )
        val expectedBook = Book(1, "asd", "asd", 1)

        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter
        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook
        assertThrows(RenterDoesNotHaveBook::class.java) { renterService.returnBook(expectedRenter, 1) }
    }

    @Test
    fun `Return Book`() {
        val expectedRenter = Renter(
            "test",
            "Renter1",
            mutableListOf(
                RentedBook(
                    Book(1, "asd", "asd", 1),
                ),
            ),
        )
        val expectedBook = Book(1, "asd", "asd", 1)

        every {
            renterStoreAPI.findRenterById("test")
        } returns expectedRenter

        every {
            renterStoreAPI.returnBook(1, "test")
        } returns 1

        every {
            bookStoreAPI.findBookById(1)
        } returns expectedBook
        every {
            bookStoreAPI.save(expectedBook)
        } returns expectedBook
        val result = renterService.returnBook(expectedRenter, 1)
        assertEquals(expectedRenter.id, result.id)
        assertEquals(expectedRenter.name, result.name)
    }
}
