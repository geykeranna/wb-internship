package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.repisotory.LoginRepository

internal class TestGetCurrentPhoneNumberUseCaseImpl{
    private val testRepository = mock<LoginRepository>()

    @Test
    fun `should return the same auth phone data as in repo`() = runTest{
        Mockito.`when`(testRepository.getPhoneAuth())
            .thenReturn("+79999999999")

        val useCase = GetCurrentPhoneNumberUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()
        val expected = "+79999999999"

        Assertions.assertEquals(expected, actual)
    }
}