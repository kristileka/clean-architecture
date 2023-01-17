package kristileka.cleanarch.presentation.controller

import kristileka.cleanarch.presentation.application.UseCaseInvoker
import kristileka.cleanarch.presentation.application.product.CreateTodoUseCase
import kristileka.cleanarch.presentation.application.product.GetAllTodosUseCase
import kristileka.cleanarch.presentation.application.product.GetTodosByStatusUseCase
import kristileka.cleanarch.presentation.domain.dto.TodoDto
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

    override fun createUpdateTodo(todoDto: TodoDto): TodoDto {
        return useCaseInvoker.invoke(
            createTodoUseCase, CreateTodoUseCase.InputValues(todoDto)
        ) { output ->
            output.todo
        }
    }

}