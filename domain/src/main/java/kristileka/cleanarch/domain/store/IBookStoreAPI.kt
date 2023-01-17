package kristileka.cleanarch.domain.store

import kristileka.cleanarch.domain.model.Book

interface IBookStoreAPI {
    fun getBooks(): List<Book>
    fun getBookById(id: Long): Book?
    fun getBookByName(name: String): Book?
    fun importBook(book: Book): Book
    fun exportBook(bookId: Long): Boolean
    fun findAllByCategoryAndAuthor(category: String, author: String): List<Book>
}