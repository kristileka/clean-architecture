package kristileka.cleanarch.application.product

import kristileka.cleanarch.application.UseCase
import kristileka.cleanarch.domain.TodoService
import kristileka.cleanarch.domain.dto.TodoDto
import org.springframework.stereotype.Component

@Component
class CreateTodoUseCase(
    private val todoService: TodoService
) : UseCase<CreateTodoUseCase.Input, CreateTodoUseCase.Output>() {

    class Input(val todo: TodoDto) : UseCase.Input

    class Output(val todo: TodoDto) : UseCase.Output

    override fun invoke(input: Input): Output {
        return Output(todoService.createTodo(input.todo))
    }
}