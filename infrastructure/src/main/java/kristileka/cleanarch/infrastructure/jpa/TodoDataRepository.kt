package kristileka.cleanarch.infrastructure.jpa

import kristileka.cleanarch.infrastructure.entities.TodoData
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface TodoDataRepository : JpaRepository<TodoData, Long>, JpaSpecificationExecutor<TodoData> {
    fun findAllByStatus(status: String): List<TodoData>
    override fun findAll(): List<TodoData>
}