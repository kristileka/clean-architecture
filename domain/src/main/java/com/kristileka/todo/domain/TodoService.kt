package com.kristileka.todo.domain

import com.kristileka.todo.domain.dto.TodoDto
import java.math.BigDecimal

interface TodoService {
    fun findAll(): List<TodoDto>
    fun findAllTodoByStatus(status: String): List<TodoDto>
    fun createTodo(todo: TodoDto): TodoDto
}