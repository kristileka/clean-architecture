package com.kristileka.todo.domain.mapper

import com.kristileka.todo.domain.dto.TodoDto
import com.kristileka.todo.infrastructure.entities.TodoData
import java.time.LocalDate
import java.time.LocalDateTime

object TodoMapper {
    fun TodoData.toDto(): TodoDto {
        return TodoDto(
            this.id.toString(),
            this.name.toString(),
            this.status.toString(),
            this.createdAt.toString(),
            this.description.toString(),
            this.targetDate.toString()
        )
    }

    fun TodoDto.toData(): TodoData {
        return TodoData().also {
            if (this.id != null)
                it.id = this.id?.toLongOrNull()
            it.name = this.name
            it.status = this.status
            it.targetDate = LocalDate.parse(this.targetDate)
            it.description = this.description
        }
    }
}