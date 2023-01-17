package kristileka.cleanarch.application.base

abstract class UseCase<In : UseCase.Input?, Out : UseCase.Output?> {
    abstract fun invoke(input: In): Out
    interface Input
    interface Output
}