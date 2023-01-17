package kristileka.cleanarch.domain.impl

import kristileka.cleanarch.infrastructure.entities.TodoData
import kristileka.cleanarch.infrastructure.jpa.TodoDataRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDate
import java.time.LocalDateTime

internal class TodoServiceImplTest {
    var todoDataRepository: TodoDataRepository = Mockito.mock(TodoDataRepository::class.java)

    @Test
    fun findAllEmptyList() {
        Mockito.`when`(todoDataRepository.findAll()).thenReturn(emptyList())
        val todoServiceImpl = TodoServiceImpl(todoDataRepository)
        assertEquals(todoServiceImpl.findAll().size, 0)
    }

    @Test
    fun findAllSuccess() {
        val todoData = TodoData().apply {
            this.id = 1
            this.name = "test"
            this.description = "test"
            this.status = "done"
            this.createdAt = LocalDateTime.now()
            this.targetDate = LocalDate.now()
        }
        Mockito.`when`(todoDataRepository.findAll()).thenReturn(listOf(todoData))
        val todoServiceImpl = TodoServiceImpl(todoDataRepository)
        val response = todoServiceImpl.findAll()
        assertEquals(response.size, 1)
        assertNotNull(response.firstOrNull())
        assertEquals(response.first().name, todoData.name)
        assertEquals(response.first().description, todoData.description)
    }


    @Test
    fun findAllTodoByStatusEmpty() {
        Mockito.`when`(todoDataRepository.findAllByStatus("done")).thenReturn(emptyList())
        val todoServiceImpl = TodoServiceImpl(todoDataRepository)
        assertEquals(todoServiceImpl.findAllTodoByStatus("done").size, 0)
    }

    @Test
    fun findAllTodoByStatus() {
        val todoData = TodoData().apply {
            this.id = 1
            this.name = "test"
            this.description = "test"
            this.status = "done"
            this.createdAt = LocalDateTime.now()
            this.targetDate = LocalDate.now()
        }
        Mockito.`when`(todoDataRepository.findAllByStatus("done")).thenReturn(listOf(todoData))
        val todoServiceImpl = TodoServiceImpl(todoDataRepository)
        val response = todoServiceImpl.findAllTodoByStatus("done")
        assertEquals(response.size, 1)
        assertNotNull(response.firstOrNull())
        assertEquals(response.first().name, todoData.name)
        assertEquals(response.first().description, todoData.description)
    }


}