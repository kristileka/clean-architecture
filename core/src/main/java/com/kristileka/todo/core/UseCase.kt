package com.kristileka.todo.core

abstract class UseCase<I : UseCase.InputValues?, O : UseCase.OutputValues?> {
    abstract fun execute(input: I): O
    interface InputValues
    interface OutputValues
}