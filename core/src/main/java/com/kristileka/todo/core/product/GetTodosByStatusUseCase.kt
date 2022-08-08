package com.kristileka.todo.core.product

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
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