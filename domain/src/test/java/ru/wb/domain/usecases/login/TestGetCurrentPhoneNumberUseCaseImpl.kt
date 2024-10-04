package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.LoginRepositoryStubs

internal class TestGetCurrentPhoneNumberUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return not empty phone data as in repo`() = runTest{
        val useCase = GetCurrentPhoneNumberUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }
}