package kristileka.cleanarch.presentation.controller

import kristileka.cleanarch.presentation.domain.dto.TodoDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/todo")
interface TodosResource {
    @GetMapping
    fun getAllTodos(): List<TodoDto>

    @GetMapping("/query")
    fun getTodoByStatus(
        @RequestParam("status") status: String,
    ): List<TodoDto>

    @PostMapping
    fun createUpdateTodo(
        @RequestBody todoDto: TodoDto,
    ): TodoDto
}