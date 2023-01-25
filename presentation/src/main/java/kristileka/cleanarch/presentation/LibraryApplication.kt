package kristileka.cleanarch.presentation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["kristileka.cleanarch.*"])
@ComponentScan("kristileka.cleanarch.*")
@EntityScan("kristileka.cleanarch.*")
@EnableJpaAuditing
class LibraryApplication

fun main(args: Array<String>) {
    runApplication<LibraryApplication>(*args)
}