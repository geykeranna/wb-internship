package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.repisotory.LoginRepository

class TestCheckPinCodeUseCaseImpl{
    private val testRepository = mock<LoginRepository>()

    @Test
    fun `show return the same check pin results as in repo`() = runTest{
        Mockito.`when`(testRepository.checkCode("4444"))
            .thenReturn(true)

        val useCase = CheckPinCodeUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("4444")
        val expected = true

        Assertions.assertEquals(expected, actual)
    }
}