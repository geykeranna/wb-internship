package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.UserRepositoryStubs

class TestHandleGoingEventImpl {
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `show return results handle change status going on event as in repo`() = runTest{
        val useCase = HandleGoingEventImpl(repository = testRepository)
        val actual = useCase.execute("1").last()

        Assertions.assertTrue(actual)
    }
}