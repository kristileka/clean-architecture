package com.kristileka.todo.core.impl

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.core.UseCaseInvoker
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class UseCaseInvokerImpl : UseCaseInvoker {
    override fun <In : UseCase.Input, Out : UseCase.Output>
            execute(useCase: UseCase<In, Out>, input: In): Out {
        return useCase.invoke(input)
    }
}