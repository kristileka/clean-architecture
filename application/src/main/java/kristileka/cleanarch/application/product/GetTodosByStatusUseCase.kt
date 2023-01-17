package kristileka.cleanarch.application.product

import kristileka.cleanarch.application.UseCase
import kristileka.cleanarch.domain.TodoService
import kristileka.cleanarch.domain.dto.TodoDto
import org.springframework.stereotype.Component


@Component
class GetTodosByStatusUseCase(
    val todoService: TodoService
) :
    UseCase<GetTodosByStatusUseCase.Input, GetTodosByStatusUseCase.Output>() {

    class Input(val status: String) : UseCase.Input
    class Output(val todos: List<TodoDto>) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(todoService.findAllTodoByStatus(input.status))
    }
}