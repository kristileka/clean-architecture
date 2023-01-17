package kristileka.cleanarch.domain.exceptions

open class GeneralExceptions(message: String) : Exception(message)

class BookNotFoundException(message: String = "Book not found") : GeneralExceptions(message)
class RenterNotFoundException(message: String = "Renter not found") : GeneralExceptions(message)
class RenterAlreadyHaveBook(message: String = "Renter already have the book found") : GeneralExceptions(message)
class RenterDoesNotHaveBook(message: String = "Renter doesn't have book") : GeneralExceptions(message)
