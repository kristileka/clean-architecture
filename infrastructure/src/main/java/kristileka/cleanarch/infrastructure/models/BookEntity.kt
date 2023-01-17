package kristileka.cleanarch.infrastructure.models

import javax.persistence.*


@Entity(name = "book")
class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    var author: String? = null

    @ElementCollection
    var categories: List<String> = arrayListOf()

    var quantity: Int? = 0

}