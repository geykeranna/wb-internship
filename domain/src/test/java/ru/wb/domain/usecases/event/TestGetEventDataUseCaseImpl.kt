package ru.wb.domain.usecases.event

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.EventRepositoryStubs

class TestGetEventDataUseCaseImpl{
    private val testRepository = EventRepositoryStubs()

    @Test
    fun `should return the same event data as in repo`() = runTest {
        val useCase = GetEventDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(id = "1")

        Assertions.assertTrue(
            actual.id.isNotEmpty()
            && actual.name.isNotEmpty()
        )
    }
}