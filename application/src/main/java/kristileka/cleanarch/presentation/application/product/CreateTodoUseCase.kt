package kristileka.cleanarch.presentation.application.product

import kristileka.cleanarch.presentation.application.UseCase
import kristileka.cleanarch.presentation.domain.TodoService
import kristileka.cleanarch.presentation.domain.dto.TodoDto
import org.springframework.stereotype.Component

@Component
class CreateTodoUseCase(
    private val todoService: TodoService
) : UseCase<CreateTodoUseCase.InputValues, CreateTodoUseCase.OutputValues>() {

    class InputValues(val todo: TodoDto) : UseCase.InputValues

    class OutputValues(val todo: TodoDto) : UseCase.OutputValues

    override fun execute(input: InputValues): OutputValues {
        return OutputValues(todoService.createTodo(input.todo))
    }
}