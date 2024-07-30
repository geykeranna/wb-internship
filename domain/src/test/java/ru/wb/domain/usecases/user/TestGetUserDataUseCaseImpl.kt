package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.UserRepositoryStubs

class TestGetUserDataUseCaseImpl{
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `show return not empty id user data as in repo`() = runTest{
        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("1").last()

        Assertions.assertTrue(actual.id.isNotEmpty())
    }

    @Test
    fun `show return not empty first name user data as in repo`() = runTest{
        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("1").last()

        Assertions.assertTrue(actual.firstName.isNotEmpty())
    }

    @Test
    fun `show return not empty phone user data as in repo`() = runTest{
        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("1").last()

        Assertions.assertTrue(actual.phone.isNotEmpty())
    }
}