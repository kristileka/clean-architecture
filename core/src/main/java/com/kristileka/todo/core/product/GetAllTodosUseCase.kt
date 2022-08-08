package com.kristileka.todo.core.product

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
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