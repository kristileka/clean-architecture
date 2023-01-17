package kristileka.cleanarch.presentation.controller

import kristileka.cleanarch.application.UseCaseInvoker
import kristileka.cleanarch.application.product.CreateTodoUseCase
import kristileka.cleanarch.application.product.GetAllTodosUseCase
import kristileka.cleanarch.application.product.GetTodosByStatusUseCase
import kristileka.cleanarch.domain.dto.TodoDto
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(
    val useCaseInvoker: UseCaseInvoker,
    val getAllTodosUseCase: GetAllTodosUseCase,
    val getTodosByStatusUseCase: GetTodosByStatusUseCase,
    val createTodoUseCase: CreateTodoUseCase
) : TodoResource {
    override fun getAllTodos(): List<TodoDto> {
        return useCaseInvoker.execute(
            getAllTodosUseCase, GetAllTodosUseCase.Input()
        ).todos
    }

    override fun getTodoByStatus(status: String): List<TodoDto> {
        return useCaseInvoker.execute(
            getTodosByStatusUseCase, GetTodosByStatusUseCase.Input(status = status)
        ).todos
    }

    override fun getTodoByStatus(todoDto: TodoDto): TodoDto {
        return useCaseInvoker.execute(
            createTodoUseCase, CreateTodoUseCase.Input(todoDto)
        ).todo
    }

}