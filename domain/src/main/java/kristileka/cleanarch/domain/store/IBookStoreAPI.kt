package kristileka.cleanarch.domain.store

import kristileka.cleanarch.domain.model.Book

interface IBookStoreAPI {
    fun getBooks(): List<Book>
    fun getBookById(id: Long): Book?
    fun getBookByName(name: String): Book?
    fun findAllByCategoryAndAuthor(category: String, author: String, name: String): List<Book>
    fun save(book: Book): Book
    fun delete(bookId: Long): Boolean
}