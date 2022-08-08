package com.kristileka.todo.core.impl

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.core.UseCaseInvoker
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class UseCaseInvokerImpl : UseCaseInvoker {
    override fun <RX, I : UseCase.InputValues, O : UseCase.OutputValues> invoke(
        useCase: UseCase<I, O>,
        input: I,
        outMapper: Function<O, RX>
    ): RX {
        return outMapper.apply(useCase.execute(input))
    }
}