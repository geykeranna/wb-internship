package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.UserRepositoryStubs

class TestGetUserDataUseCaseImpl{
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `show return the same user data as in repo`() = runTest{
        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("1").last()

        if (actual != null) {
            Assertions.assertTrue(
                actual.id.isNotEmpty()
                && actual.firstName.isNotEmpty()
                && actual.phone.isNotEmpty()
            )
        }
    }

    @Test
    fun `show return null with null id as in repo`() = runTest{
        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(null).last()

        Assertions.assertEquals(null, actual)
    }
}