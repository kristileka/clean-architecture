package kristileka.cleanarch.presentation.dto.renter


class RenterREST {
    var id: String? = null
    var name: String? = null
    var rentedBooks: List<RentedBookREST> = emptyList()
}