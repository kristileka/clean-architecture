package kristileka.cleanarch.presentation.domain.impl

import kristileka.cleanarch.presentation.domain.TodoService
import kristileka.cleanarch.presentation.domain.dto.TodoDto
import kristileka.cleanarch.presentation.domain.mapper.TodoMapper.toData
import kristileka.cleanarch.presentation.domain.mapper.TodoMapper.toDto
import kristileka.cleanarch.presentation.infrastructure.jpa.TodoDataRepository
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
        return todoDataRepository.findAllByStatus(status).map {
            it.toDto()
        }
    }

    override fun createTodo(todo: TodoDto): TodoDto {
        return todoDataRepository.save(todo.toData()).toDto()
    }
}