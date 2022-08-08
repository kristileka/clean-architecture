package com.kristileka.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.kristileka.todo.**"])
class TodoApplication

fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}