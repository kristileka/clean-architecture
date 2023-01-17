package kristileka.cleanarch.application

import kristileka.cleanarch.application.impl.UseCaseInvokerImpl
import kristileka.cleanarch.application.product.CreateTodoUseCase
import kristileka.cleanarch.domain.TodoService
import kristileka.cleanarch.domain.dto.TodoDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito


class CreateTodoUseCaseTest {
    private var useCaseInvoker = UseCaseInvokerImpl()
    private var todoService: TodoService = Mockito.mock(TodoService::class.java)

    @Test
    fun createTodoCase() {
        val todoDTO = TodoDto("", "", "", "", "", "")
        val useCase = CreateTodoUseCase(todoService)
        Mockito.`when`(todoService.createTodo(todoDTO)).thenReturn(todoDTO)
        val response = useCaseInvoker.execute(useCase, CreateTodoUseCase.Input(todoDTO))
        assertEquals(response.todo.name, todoDTO.name)
        assertEquals(response.todo.status, todoDTO.status)
    }
}
