package com.kristileka.todo.core.product

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
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