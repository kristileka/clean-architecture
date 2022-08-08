package com.kristileka.todo.core.product

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
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