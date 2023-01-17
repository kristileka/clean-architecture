package kristileka.cleanarch.application.product

import kristileka.cleanarch.application.UseCase
import kristileka.cleanarch.domain.TodoService
import kristileka.cleanarch.domain.dto.TodoDto
import org.springframework.stereotype.Component

@Component
class GetAllTodosUseCase(
    private val todoService: TodoService
) : UseCase<GetAllTodosUseCase.Input, GetAllTodosUseCase.Output>() {

    class Input : UseCase.Input

    class Output(val todos: List<TodoDto>) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(todoService.findAll())
    }
}