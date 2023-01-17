package kristileka.cleanarch.application.impl

import kristileka.cleanarch.application.UseCase
import kristileka.cleanarch.application.UseCaseInvoker
import org.springframework.stereotype.Component

@Component
class UseCaseInvokerImpl : UseCaseInvoker {
    override fun <In : UseCase.Input, Out : UseCase.Output>
            execute(useCase: UseCase<In, Out>, input: In): Out {
        return useCase.invoke(input)
    }
}