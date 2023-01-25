package kristileka.cleanarch.infrastructure.models

import kristileka.cleanarch.infrastructure.models.base.BaseEntity
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity(name = "renter")
@SQLDelete(sql = "UPDATE renter SET deleted_at=now() WHERE id=?")
@Where(clause = "deleted_at is NULL")
class RenterEntity : BaseEntity() {
    @Id
    @Column(name = "id", nullable = false)
    var id: String? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
    )
    @JoinColumn(name = "renter_id")
    var rentedBooks: MutableList<RentedBookEntity> = mutableListOf()
}
