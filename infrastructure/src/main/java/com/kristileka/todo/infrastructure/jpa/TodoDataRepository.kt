package com.kristileka.todo.infrastructure.jpa

import com.kristileka.todo.infrastructure.entities.TodoData
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface TodoDataRepository : JpaRepository<TodoData, Long>, JpaSpecificationExecutor<TodoData> {
    fun findAllByStatus(status: String): List<TodoData>
    override fun findAll(): List<TodoData>
}