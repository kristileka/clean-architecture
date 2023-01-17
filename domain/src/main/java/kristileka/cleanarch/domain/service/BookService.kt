package kristileka.cleanarch.domain.service

import kristileka.cleanarch.domain.exceptions.BookNotFoundException
import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.store.IBookStoreAPI
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookStoreAPI: IBookStoreAPI
) {
    fun queryBooks(category: String?, author: String?): List<Book> {
        return bookStoreAPI.findAllByCategoryAndAuthor(category ?: "", author ?: "")
    }

    fun getBooks(): List<Book> {
        return bookStoreAPI.getBooks()
    }

    fun getBookById(id: Long): Book {
        return bookStoreAPI.getBookById(id) ?: throw BookNotFoundException()
    }

    fun getBookAvailability(id: Long): Boolean {
        val book = getBookById(id)
        return book.quantity != null && book.quantity!! > 0
    }

    fun importBook(book: Book): Book {
        val bookToImport = bookStoreAPI.getBookByName(book.name!!) ?: book.apply {
            this.quantity = 1
        }
        bookToImport.apply {
            this.quantity = this.quantity?.plus(1)
        }
        return bookStoreAPI.importBook(bookToImport)
    }

    fun exportBook(bookId: Long): Boolean {
        return bookStoreAPI.exportBook(bookId)
    }
}