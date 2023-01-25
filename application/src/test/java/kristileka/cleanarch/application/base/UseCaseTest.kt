package kristileka.cleanarch.application.base

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UseCaseTest {
    private val mockedUseCase = mockk<UseCase<UseCaseTest.TestInput, UseCaseTest.TestOutput>>()
    private val mockedInput = TestInput()
    private val mockedOutput = TestOutput()

    @Test
    fun `test invoke method`() {
        every { mockedUseCase.invoke(mockedInput) } returns mockedOutput
        val output = mockedUseCase.invoke(mockedInput)
        assertEquals(mockedOutput, output)
    }

    inner class TestInput : UseCase.Input
    inner class TestOutput : UseCase.Output
}