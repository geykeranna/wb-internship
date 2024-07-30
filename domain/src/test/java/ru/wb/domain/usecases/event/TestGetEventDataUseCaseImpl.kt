package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.EventRepositoryStubs

class TestGetEventDataUseCaseImpl{
    private val testRepository = EventRepositoryStubs()

    @Test
    fun `should return not empty id event data as in repo`() = runTest {
        val useCase = GetEventDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(id = "1").last()

        Assertions.assertTrue(actual.id.isNotEmpty())
    }

    @Test
    fun `should return not empty name event data as in repo`() = runTest {
        val useCase = GetEventDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(id = "1").last()

        Assertions.assertTrue(actual.name.isNotEmpty())
    }
}