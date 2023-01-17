package kristileka.cleanarch.presentation.infrastructure.entities

import org.hibernate.annotations.Where
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity(name = "todo")
//@Where(clause = "deletedAt=null")
class TodoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var description: String? = null

    var status: String? = null

    @Column(nullable = false, unique = true, updatable = false, columnDefinition = "TIMESTAMP")
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @Column(name = "target_date", columnDefinition = "DATE")
    var targetDate: LocalDate? = null
    var deletedAt: LocalDateTime? = null
}
