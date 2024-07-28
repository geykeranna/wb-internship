package ru.wb.domain.usecases.event

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.EventRepositoryStubs

class TestGetEventListUseCaseImpl {
    private val testRepository = EventRepositoryStubs()

    @Test
    fun `should return the same event list data as in repo`() = runTest{
        val useCase = GetEventListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertTrue(actual.isNotEmpty())
    }

    @Test
    fun `should return the same count event list limit data in list as in repo `() = runTest{
        val expectedLimit = 10

        val useCase = GetEventListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(limit = expectedLimit)

        Assertions.assertEquals(expectedLimit, actual.size)
    }
}