package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.UserRepositoryStubs

class TestChangeSubscriptionEventStatusUseCaseImpl {
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `should return results handle change status going on event as in repo`() = runTest{
        val useCase = ChangeSubscriptionEventStatusUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("1").last()

        Assertions.assertTrue(actual)
    }
}