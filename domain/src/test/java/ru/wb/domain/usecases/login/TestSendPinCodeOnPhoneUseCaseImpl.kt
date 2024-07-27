package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.repisotory.LoginRepository

internal class TestSendPinCodeOnPhoneUseCaseImpl{
    private val testRepository = mock<LoginRepository>()

    @Test
    fun `show return the same send pin on phone results as in repo`() = runTest{
        Mockito.`when`(testRepository.sendOnPhone("89099099900"))
            .thenReturn(true)

        val useCase = SendPinCodeOnPhoneUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("89099099900")
        val expected = true

        Assertions.assertEquals(expected, actual)
    }
}