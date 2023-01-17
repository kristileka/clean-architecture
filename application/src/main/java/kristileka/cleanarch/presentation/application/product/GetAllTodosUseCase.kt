package kristileka.cleanarch.presentation.application.product

import kristileka.cleanarch.presentation.application.UseCase
import kristileka.cleanarch.presentation.domain.TodoService
import kristileka.cleanarch.presentation.domain.dto.TodoDto
import org.springframework.stereotype.Component

@Component
class GetAllTodosUseCase(
    private val todoService: TodoService
) : UseCase<GetAllTodosUseCase.InputValues, GetAllTodosUseCase.OutputValues>() {

    class InputValues : UseCase.InputValues

    class OutputValues(val todos: List<TodoDto>) : UseCase.OutputValues

    override fun execute(input: InputValues): OutputValues {
        return OutputValues(todoService.findAll())
    }
}