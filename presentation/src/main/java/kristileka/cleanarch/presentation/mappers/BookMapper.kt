package kristileka.cleanarch.presentation.mappers

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.presentation.dto.book.BookREST

object BookMapper {
    fun Book.toREST(): BookREST {
        return BookREST().also {
            it.id = this.id
            it.name = this.name
            it.author = this.author
            it.categories = this.categories
        }
    }

    fun BookREST.toDomain(): Book {
        return Book(name = this.name, author = this.author, categories = this.categories)
    }
}
