package kristileka.cleanarch.application

interface UseCaseInvoker {
    fun <In : UseCase.Input, Out : UseCase.Output> execute(
        useCase: UseCase<In, Out>,
        input: In,
    ): Out
}



