package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.LoginRepositoryStubs

internal class TestSendPinCodeOnPhoneUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `show return the same send pin status on phone results as in repo`() = runTest{
        val useCase = SendPinCodeOnPhoneUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute("+79099099900").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data)
            else -> Assertions.assertTrue(false)
        }
    }
}