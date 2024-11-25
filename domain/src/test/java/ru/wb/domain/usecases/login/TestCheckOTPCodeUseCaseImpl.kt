package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestCheckOTPCodeUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return the same check pin status as in repo`() = runTest{
        val useCase = CheckOTPCodeUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute("4444").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data)
            else -> Assertions.assertTrue(false)
        }
    }
}