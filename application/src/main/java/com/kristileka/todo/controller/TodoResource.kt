package com.kristileka.todo.controller

import com.kristileka.todo.domain.dto.TodoDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/api/v1/todo")
interface TodoResource {
    @GetMapping
    fun getAllTodos(): List<TodoDto>

    @GetMapping("/query")
    fun getTodoByStatus(
        @RequestParam("status") status: String,
    ): List<TodoDto>

    @PostMapping
    fun getTodoByStatus(
        @RequestBody todoDto: TodoDto,
    ): TodoDto
}