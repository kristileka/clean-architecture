package com.kristileka.todo.core.impl

import com.kristileka.todo.core.UseCase
import com.kristileka.todo.core.UseCaseInvoker
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class UseCaseInvokerImpl : UseCaseInvoker {
    override fun <Value, In : UseCase.Input, Out : UseCase.Output> invoke(
        useCase: UseCase<In, Out>,
        input: In,
        outMapper: Function<Out, Value>
    ): Value {
        return outMapper.apply(useCase.invoke(input))
    }
}