package com.kristileka.todo.controller

import com.kristileka.todo.core.UseCaseInvoker
import com.kristileka.todo.core.product.CreateTodoUseCase
import com.kristileka.todo.core.product.GetAllTodosUseCase
import com.kristileka.todo.core.product.GetTodosByStatusUseCase
import com.kristileka.todo.domain.dto.TodoDto
import org.springframework.stereotype.Component

@Component
class TodosController(
    val useCaseInvoker: UseCaseInvoker,
    val getAllTodosUseCase: GetAllTodosUseCase,
    val getTodosByStatusUseCase: GetTodosByStatusUseCase,
    val createTodoUseCase: CreateTodoUseCase
) : TodosResource {
    override fun getAllTodos(): List<TodoDto> {
        return useCaseInvoker.invoke(
            getAllTodosUseCase, GetAllTodosUseCase.InputValues()
        ) { output ->
            output.todos
        }
    }

    override fun getTodoByStatus(status: String): List<TodoDto> {
        return useCaseInvoker.invoke(
            getTodosByStatusUseCase, GetTodosByStatusUseCase.InputValues(
                status = status
            )
        ) { output ->
            output.todos
        }
    }

    override fun getTodoByStatus(todoDto: TodoDto): TodoDto {
        return useCaseInvoker.invoke(
            createTodoUseCase, CreateTodoUseCase.InputValues(todoDto)
        ) { output ->
            output.todo
        }
    }

}