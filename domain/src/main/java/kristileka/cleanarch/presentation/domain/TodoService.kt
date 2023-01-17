package kristileka.cleanarch.presentation.domain

import kristileka.cleanarch.presentation.domain.dto.TodoDto
import java.math.BigDecimal

interface TodoService {
    fun findAll(): List<TodoDto>
    fun findAllTodoByStatus(status: String): List<TodoDto>
    fun createTodo(todo: TodoDto): TodoDto
}