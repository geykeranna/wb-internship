package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestGetCurrentUserIDUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return not empty auth user id data as in repo`() = runTest{
        val useCase = GetCurrentUserIDUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }
}