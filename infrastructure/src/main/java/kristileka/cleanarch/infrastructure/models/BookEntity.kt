package kristileka.cleanarch.infrastructure.models

import kristileka.cleanarch.infrastructure.models.base.BaseEntity
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import kotlin.Int
import kotlin.Long
import kotlin.String

@Entity(name = "book")
@SQLDelete(sql = "UPDATE book SET deleted_at=now() WHERE id=?")
@Where(clause = "deleted_at is NULL")
class BookEntity : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String = ""

    @Column(name = "author", nullable = false)
    var author: String = ""

    @ElementCollection
    var categories: List<String> = arrayListOf()

    var quantity: Int = 0
}
