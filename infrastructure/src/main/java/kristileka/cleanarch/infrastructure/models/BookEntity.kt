package kristileka.cleanarch.infrastructure.models

import kristileka.cleanarch.infrastructure.models.base.BaseEntity
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.lang.Boolean
import java.time.LocalDateTime
import javax.persistence.*
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