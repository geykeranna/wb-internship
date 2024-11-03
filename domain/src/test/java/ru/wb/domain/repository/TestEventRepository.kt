package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.EventRepositoryStubs

class TestEventRepository {
    private val testRepository = EventRepositoryStubs()

    @Test
    fun `should return not empty id event data`() = runTest {
        when(val actual = testRepository.getEvent("1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.id.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty name event data`() = runTest {
        when(val actual = testRepository.getEvent(id = "1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.name.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty event data list`() = runTest {
        when(val actual = testRepository.getEvents().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.data.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }
}