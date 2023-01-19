package kristileka.cleanarch.infrastructure.models.base

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.lang.Boolean
import java.time.LocalDateTime
import javax.persistence.*


@MappedSuperclass
@Where(clause = "deleted=false")
abstract class BaseEntity {

    val deleted = Boolean.FALSE

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null

//    @PreUpdate
//    protected open fun preUpdate() {
//        this.updatedAt = LocalDateTime.now()
//    }

}