package kristileka.cleanarch.presentation.application

import java.util.function.Function

interface UseCaseInvoker {
    fun <RX, I : UseCase.InputValues, O : UseCase.OutputValues> invoke(
        useCase: UseCase<I, O>,
        input: I,
        outMapper: Function<O, RX>
    ): RX
}



