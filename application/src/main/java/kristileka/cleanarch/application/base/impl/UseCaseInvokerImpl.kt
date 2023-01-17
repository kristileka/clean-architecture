package kristileka.cleanarch.application.base.impl

import kristileka.cleanarch.application.base.UseCase
import kristileka.cleanarch.application.base.UseCaseInvoker
import org.springframework.stereotype.Component

@Component
class UseCaseInvokerImpl : UseCaseInvoker {
    override fun <In : UseCase.Input, Out : UseCase.Output>
            execute(useCase: UseCase<In, Out>, input: In): Out {
        return useCase.invoke(input)
    }
}