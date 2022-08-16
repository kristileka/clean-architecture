package com.kristileka.todo.core.product

import com.kristileka.todo.core.impl.UseCaseInvokerImpl
import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class GetAllTodosUseCaseTest {
    var useCaseInvoker = UseCaseInvokerImpl()
    var todoService: TodoService = Mockito.mock(TodoService::class.java)

    @Test
    fun getAllTodosEmpty() {
        val useCase = GetAllTodosUseCase(todoService)
        Mockito.`when`(todoService.findAll()).thenReturn(emptyList())
        val response = useCaseInvoker.execute(useCase, GetAllTodosUseCase.Input())
        assertEquals(response.todos.size, 0)
    }

    @Test
    fun getAllTodosList() {
        val todoDTO = TodoDto("", "", "", "", "", "")
        val useCase = GetAllTodosUseCase(todoService)
        Mockito.`when`(todoService.findAll()).thenReturn(listOf(todoDTO))
        val response = useCaseInvoker.execute(useCase, GetAllTodosUseCase.Input())
        assertEquals(response.todos.size, 1)
        assertNotNull(response.todos.firstOrNull())
        assertEquals(response.todos.first().name, todoDTO.name)
        assertEquals(response.todos.first().description, todoDTO.description)
    }
}