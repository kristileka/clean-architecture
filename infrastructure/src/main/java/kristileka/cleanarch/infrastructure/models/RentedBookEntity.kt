package kristileka.cleanarch.infrastructure.models

import java.time.LocalDate
import javax.persistence.*


@Entity(name = "rented_book")
class RentedBookEntity {
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