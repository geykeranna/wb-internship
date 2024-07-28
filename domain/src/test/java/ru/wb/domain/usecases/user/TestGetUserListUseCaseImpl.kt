package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.UserRepositoryStubs

internal class TestGetUserListUseCaseImpl{
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `show return the same list user data as in repo`() = runTest{
        val useCase = GetUserListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute().last()

        Assertions.assertTrue(actual.isNotEmpty())
    }

    @Test
    fun `show return the same list limit user data as in repo`() = runTest{
        val expectedLimit = 10

        val useCase = GetUserListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(limit = expectedLimit).last()

        Assertions.assertTrue(actual.isNotEmpty())
    }
}
