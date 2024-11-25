package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.EventRepositoryStubs

class TestGetEventDataUseCaseImpl{
    private val testRepository = EventRepositoryStubs()

    @Test
    fun `should return not empty id event data as in repo`() = runTest {
        val useCase = GetEventDataUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute(id = "1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.id.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty name event data as in repo`() = runTest {
        val useCase = GetEventDataUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute(id = "1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.name.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }
}