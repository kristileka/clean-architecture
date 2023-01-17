package kristileka.cleanarch.presentation.application.product

import kristileka.cleanarch.presentation.application.UseCase
import kristileka.cleanarch.presentation.domain.TodoService
import kristileka.cleanarch.presentation.domain.dto.TodoDto
import org.springframework.stereotype.Component


@Component
class GetTodosByStatusUseCase(
    val todoService: TodoService
) :
    UseCase<GetTodosByStatusUseCase.InputValues, GetTodosByStatusUseCase.OutputValues>() {

    class InputValues(val status: String) : UseCase.InputValues
    class OutputValues(val todos: List<TodoDto>) : UseCase.OutputValues

    override fun execute(input: InputValues): OutputValues {
        return OutputValues(todoService.findAllTodoByStatus(input.status))
    }
}