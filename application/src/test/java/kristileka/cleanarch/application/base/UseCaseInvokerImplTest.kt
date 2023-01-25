package kristileka.cleanarch.application.base

import io.mockk.every
import io.mockk.mockk
import kristileka.cleanarch.application.base.impl.UseCaseInvokerImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UseCaseInvokerImplTest {
    private val useCaseInvoker = UseCaseInvokerImpl()
    private val mockedUseCase = mockk<UseCase<UseCase.Input, UseCase.Output>>()
    private val mockedInput = mockk<UseCase.Input>()
    private val mockedOutput = mockk<UseCase.Output>()

    @Test
    fun `test execute method`() {
        every {
            mockedUseCase.invoke(mockedInput)
        } returns mockedOutput
        val output = useCaseInvoker.execute(mockedUseCase, mockedInput)
        assertEquals(mockedOutput, output)
    }
}