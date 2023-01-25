package kristileka.cleanarch.infrastructure.mappers

import kristileka.cleanarch.domain.model.Book
import kristileka.cleanarch.infrastructure.models.BookEntity

object BookEntityMapper {
    fun BookEntity.toDomain(): Book {
        return Book(this.id, this.name, this.author, this.quantity, this.categories)
    }

    fun Book.toEntity(): BookEntity {
        return BookEntity().also {
            it.id = this.id
            it.name = this.name
            it.author = this.author
            it.quantity = this.quantity
            it.categories = this.categories
        }
    }
}
