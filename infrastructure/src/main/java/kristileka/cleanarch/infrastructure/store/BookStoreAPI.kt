package kristileka.cleanarch.infrastructure.store

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.domain.store.IBookStoreAPI
import kristileka.cleanarch.infrastructure.repository.BookRepository
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toDomain
import kristileka.cleanarch.infrastructure.mappers.BookEntityMapper.toEntity
import org.springframework.stereotype.Service

@Service
class BookStoreAPI(
    val bookRepository: BookRepository
) : IBookStoreAPI {

    override fun findAll(): List<Book> {
        return bookRepository.findAll().map { it.toDomain() }
    }

    override fun findBookById(id: Long): Book? {
        val response = bookRepository.findById(id)
        return if (response.isPresent) response.get().toDomain() else null
    }

    override fun findBookByName(name: String): Book? {
        return bookRepository.findByName(name)?.toDomain()
    }

    override fun save(book: Book): Book {
        return bookRepository.save(book.toEntity()).toDomain()
    }

    override fun delete(bookId: Long): Boolean {
        bookRepository.deleteById(bookId)
        return true
    }

    override fun findAllByCategoryAndAuthor(category: String, author: String, name: String): List<Book> {
        return bookRepository.findByCategoryAndAuthorAndName(category, author, name).map {
            it.toDomain()
        }
    }

}