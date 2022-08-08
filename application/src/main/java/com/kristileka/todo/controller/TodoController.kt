package com.kristileka.todo.controller

import com.kristileka.todo.core.UseCaseInvoker
import com.kristileka.todo.core.product.CreateTodoUseCase
import com.kristileka.todo.core.product.GetAllTodosUseCase
import com.kristileka.todo.core.product.GetTodosByStatusUseCase
import com.kristileka.todo.domain.dto.TodoDto
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(
    val useCaseInvoker: UseCaseInvoker,
    val getAllTodosUseCase: GetAllTodosUseCase,
    val getTodosByStatusUseCase: GetTodosByStatusUseCase,
    val createTodoUseCase: CreateTodoUseCase
) : TodoResource {
    override fun getAllTodos(): List<TodoDto> {
        return useCaseInvoker.invoke(
            getAllTodosUseCase, GetAllTodosUseCase.Input()
        ) { output ->
            output.todos
        }
    }

    override fun getTodoByStatus(status: String): List<TodoDto> {
        return useCaseInvoker.invoke(
            getTodosByStatusUseCase, GetTodosByStatusUseCase.Input(status = status)
        ) { output ->
            output.todos
        }
    }

    override fun getTodoByStatus(todoDto: TodoDto): TodoDto {
        return useCaseInvoker.invoke(
            createTodoUseCase, CreateTodoUseCase.Input(todoDto)
        ) { output ->
            output.todo
        }
    }

}