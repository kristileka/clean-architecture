package kristileka.cleanarch.infrastructure.models

import kristileka.cleanarch.infrastructure.models.base.BaseEntity
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.lang.Boolean
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*


@Entity(name = "rented_book")
@SQLDelete(sql = "UPDATE rented_book SET deleted_at=now() WHERE id=?")
@Where(clause = "deleted_at is NULL")
class RentedBookEntity : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    var book: BookEntity? = null

    var rentDate: LocalDate? = LocalDate.now()

    var returnDate: LocalDate? = LocalDate.now().plusDays(15)

}