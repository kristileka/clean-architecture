package com.kristileka.todo.core

import java.util.function.Function

interface UseCaseInvoker {
    fun <Value, In : UseCase.Input, Out : UseCase.Output> invoke(
        useCase: UseCase<In, Out>,
        input: In,
        outMapper: Function<Out, Value>
    ): Value
}



