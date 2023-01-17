package kristileka.cleanarch.application

import kristileka.cleanarch.application.impl.UseCaseInvokerImpl
import kristileka.cleanarch.application.product.GetTodosByStatusUseCase
import kristileka.cleanarch.domain.TodoService
import kristileka.cleanarch.domain.dto.TodoDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class GetTodosByStatusUseCaseTest {
    var useCaseInvoker = UseCaseInvokerImpl()
    var todoService: TodoService = Mockito.mock(TodoService::class.java)

    @Test
    fun getAllTodosEmpty() {
        val useCase = GetTodosByStatusUseCase(todoService)
        Mockito.`when`(todoService.findAllTodoByStatus("test")).thenReturn(emptyList())
        val response = useCaseInvoker.execute(useCase, GetTodosByStatusUseCase.Input("test"))
        assertEquals(response.todos.size, 0)
    }

    @Test
    fun getAllTodosList() {
        val todoDTO = TodoDto("", "", "", "", "", "")
        val useCase = GetTodosByStatusUseCase(todoService)
        Mockito.`when`(todoService.findAllTodoByStatus("test")).thenReturn(listOf(todoDTO))
        val response = useCaseInvoker.execute(useCase, GetTodosByStatusUseCase.Input("test"))
        assertEquals(response.todos.size, 1)
        assertNotNull(response.todos.firstOrNull())
        assertEquals(response.todos.first().name, todoDTO.name)
        assertEquals(response.todos.first().description, todoDTO.description)
    }
}