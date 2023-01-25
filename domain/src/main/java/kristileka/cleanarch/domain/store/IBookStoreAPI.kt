package kristileka.cleanarch.domain.store

import kristileka.cleanarch.domain.model.Book

interface IBookStoreAPI {
    fun findAll(): List<Book>
    fun findBookById(id: Long): Book?
    fun findBookByName(name: String): Book?
    fun findAllByCategoryAndAuthor(category: String, author: String, name: String): List<Book>
    fun save(book: Book): Book
    fun delete(bookId: Long): Boolean
}
