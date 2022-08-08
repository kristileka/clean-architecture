package com.kristileka.todo.domain.impl

import com.kristileka.todo.domain.TodoService
import com.kristileka.todo.domain.dto.TodoDto
import com.kristileka.todo.domain.mapper.TodoMapper.toData
import com.kristileka.todo.domain.mapper.TodoMapper.toDto
import com.kristileka.todo.infrastructure.jpa.TodoDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    val todoDataRepository: TodoDataRepository
) : TodoService {
    override fun findAll(): List<TodoDto> {
        return todoDataRepository.findAll().map {
            it.toDto()
        }
    }

    override fun findAllTodoByStatus(status: String): List<TodoDto> {
        return todoDataRepository.findAllByStatus(status)
            .map {
                it.toDto()
            }
    }

    override fun createTodo(todo: TodoDto): TodoDto {
        return todoDataRepository.save(todo.toData()).toDto()
    }
}