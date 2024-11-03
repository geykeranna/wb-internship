package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.EventRepositoryStubs

class TestGetEventListUseCaseImpl {
    private val testRepository = EventRepositoryStubs()

    @Test
    fun `should return not empty event list data as in repo`() = runTest{
        val useCase = GetEventListUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.data.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return the same count event list limit data in list as in repo `() = runTest{
        val expectedLimit = 10

        val useCase = GetEventListUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute(limit = expectedLimit).last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertEquals(expectedLimit, actual.data.data.size)
            else -> Assertions.assertTrue(false)
        }
    }
}