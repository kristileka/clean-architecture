package kristileka.cleanarch.presentation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["kristileka.cleanarch.**"])
class TodoApplication

fun main(args: Array<String>) {
    runApplication<TodoApplication>(*args)
}