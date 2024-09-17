package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.EventRepositoryStubs

class TestEventRepository {
    private val testRepository = EventRepositoryStubs()

    @Test
    fun `should return not empty id event data`() = runTest {
        val actual = testRepository.getEvent("1").last()

        Assertions.assertTrue(actual.id.isNotEmpty())
    }

    @Test
    fun `should return not empty name event data`() = runTest {
        val actual = testRepository.getEvent(id = "1").last()

        Assertions.assertTrue(actual.name.isNotEmpty())
    }

    @Test
    fun `should return not empty event data list`() = runTest {
        val actual = testRepository.getEvents().last()

        Assertions.assertTrue(actual.data.isNotEmpty())
    }
}