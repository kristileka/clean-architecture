package com.kristileka.todo.infrastructure.entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class TodoInfrastructureEntitiesTest {
    @Test
    fun testInfrastructureEntities() {
        val todoEntity = TodoData()
        val createdDate = LocalDateTime.now()
        val targetDate = LocalDate.now()
        todoEntity.id = 1L
        todoEntity.name = "Test"
        todoEntity.description = "description"
        todoEntity.targetDate = targetDate
        todoEntity.status = "Done"
        todoEntity.createdAt = createdDate
        todoEntity.deletedAt = null

        assertEquals(todoEntity.id, 1L)
        assertEquals(todoEntity.name, "Test")
        assertEquals(todoEntity.description, "description")
        assertEquals(todoEntity.status, "Done")
        assertEquals(todoEntity.targetDate, targetDate)
        assertEquals(todoEntity.createdAt, createdDate)
        assertNull(todoEntity.deletedAt)

    }
}