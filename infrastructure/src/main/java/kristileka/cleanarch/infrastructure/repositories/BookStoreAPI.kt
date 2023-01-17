package kristileka.cleanarch.infrastructure.repositories

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.store.IBookStoreAPI
import kristileka.cleanarch.infrastructure.datasource.BookRepository
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toDomain
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toEntity
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class BookStoreAPI(
    val bookRepository: BookRepository
) : IBookStoreAPI {

    override fun getBooks(): List<Book> {
        return bookRepository.findAll().map { it.toDomain() }
    }

    override fun getBookById(id: Long): Book? {
        val response = bookRepository.findById(id)
        return if (response.isPresent) response.get().toDomain() else null
    }

    override fun getBookByName(name: String): Book? {
        return bookRepository.findByName(name)?.toDomain()
    }

    override fun importBook(book: Book): Book {
        return bookRepository.save(book.toEntity()).toDomain()
    }

    override fun exportBook(bookId: Long): Boolean {
        bookRepository.deleteById(bookId)
        return true
    }

    override fun findAllByCategoryAndAuthor(category: String, author: String): List<Book> {
        return bookRepository.findByCategoryAndAuthor(category, author).map {
            it.toDomain()
        }
    }
}