package kristileka.cleanarch.domain.model

import java.time.LocalDate

data class RentedBook(
    var book: Book?,
    var bookRentDate: LocalDate? = LocalDate.now(),
    var bookReturnDate: LocalDate? = LocalDate.now().plusDays(15),
)
