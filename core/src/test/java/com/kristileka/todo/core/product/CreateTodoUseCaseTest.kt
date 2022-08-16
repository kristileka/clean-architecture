package com.kristileka.todo.core.product

import com.kristileka.todo.core.impl.UseCaseInvokerImpl
import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class CreateTodoUseCaseTest {
    var useCaseInvoker = UseCaseInvokerImpl()
    var todoService: TodoService = Mockito.mock(TodoService::class.java)

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
