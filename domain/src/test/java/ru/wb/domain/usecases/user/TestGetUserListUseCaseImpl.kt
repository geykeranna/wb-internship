package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.UserRepositoryStubs

internal class TestGetUserListUseCaseImpl{
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `should return not empty list user data as in repo`() = runTest{
        val useCase = GetUserListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute().last()

        Assertions.assertTrue(actual.data.isNotEmpty())
    }

    @Test
    fun `should return the size of user data list the same as limit`() = runTest{
        val expectedLimit = 10

        val useCase = GetUserListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(limit = expectedLimit).last()

        Assertions.assertEquals(expectedLimit, actual.data.size)
    }
}
