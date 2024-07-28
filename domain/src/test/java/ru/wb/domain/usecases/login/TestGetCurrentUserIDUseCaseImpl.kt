package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestGetCurrentUserIDUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return the same auth user id data as in repo`() = runTest{
        val useCase = GetCurrentUserIDUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertTrue(actual.isNotEmpty())
    }
}