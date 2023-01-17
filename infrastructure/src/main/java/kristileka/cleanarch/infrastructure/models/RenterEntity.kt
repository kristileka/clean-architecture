package kristileka.cleanarch.infrastructure.models

import javax.persistence.*

@Entity(name = "renter")
class RenterEntity {
    @Id
    @Column(name = "id", nullable = false)
    var id: String? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @JoinColumn(name = "renter_id")
    var rentedBooks: MutableList<RentedBookEntity> = mutableListOf()


}