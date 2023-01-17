package kristileka.cleanarch.presentation.application.impl

import kristileka.cleanarch.presentation.application.UseCase
import kristileka.cleanarch.presentation.application.UseCaseInvoker
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