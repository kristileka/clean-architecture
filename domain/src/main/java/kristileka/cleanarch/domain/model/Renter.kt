package kristileka.cleanarch.domain.model

data class Renter(
    var id: String?,
    var name: String?,
    var rentedBooks: MutableList<RentedBook> = mutableListOf(),
)
