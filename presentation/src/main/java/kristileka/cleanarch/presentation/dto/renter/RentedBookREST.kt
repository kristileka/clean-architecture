package kristileka.cleanarch.presentation.dto.renter

import kristileka.cleanarch.presentation.dto.book.BookREST
import java.time.LocalDate

class RentedBookREST {
    var book: BookREST? = null
    var bookRentDate: LocalDate? = null
    var bookReturnDate: LocalDate? = null
}
