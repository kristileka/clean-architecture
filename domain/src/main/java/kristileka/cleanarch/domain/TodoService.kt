package kristileka.cleanarch.domain

import kristileka.cleanarch.domain.dto.TodoDto

interface TodoService {
    fun findAll(): List<TodoDto>
    fun findAllTodoByStatus(status: String): List<TodoDto>
    fun createTodo(todo: TodoDto): TodoDto
}