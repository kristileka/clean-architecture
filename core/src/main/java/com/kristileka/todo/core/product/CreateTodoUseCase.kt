package com.kristileka.todo.core.product

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
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