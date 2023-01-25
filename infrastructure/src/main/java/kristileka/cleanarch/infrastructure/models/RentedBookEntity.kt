package kristileka.cleanarch.infrastructure.models

import kristileka.cleanarch.infrastructure.models.base.BaseEntity
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import java.time.LocalDate
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

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
