package com.kristileka.todo.domain.mapper

import com.kristileka.todo.domain.dto.TodoDto
import com.kristileka.todo.domain.mapper.TodoMapper.toDto
import com.kristileka.todo.infrastructure.entities.TodoData
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class TodoMapperTest {
    @Test
    fun testMappersToDTO() {
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
        val objectData = todoEntity.toDto()
        assertEquals(objectData.id, 1L.toString())
        assertEquals(objectData.name, "Test")
        assertEquals(objectData.description, "description")
        assertEquals(objectData.status, "Done")
        assertEquals(objectData.targetDate, targetDate.toString())
        assertEquals(objectData.createdAt, createdDate.toString())
    }
}