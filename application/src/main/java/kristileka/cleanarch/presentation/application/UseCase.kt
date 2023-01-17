package kristileka.cleanarch.presentation.application

abstract class UseCase<I : UseCase.InputValues?, O : UseCase.OutputValues?> {
    abstract fun execute(input: I): O
    interface InputValues
    interface OutputValues
}