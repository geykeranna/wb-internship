package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.CommunityRepositoryStubs

class TestCommunityRepository {
    private val testRepository = CommunityRepositoryStubs()

    @Test
    fun `should return not empty id community data`() = runTest {
        val actual = testRepository.getCommunity("1").last()

        Assertions.assertTrue(actual.id.isNotEmpty())
    }

    @Test
    fun `should return not empty label community data`() = runTest {
        val actual = testRepository.getCommunity(id = "1").last()

        Assertions.assertTrue(actual.label.isNotEmpty())
    }

    @Test
    fun `should return not empty community data list`() = runTest {
        val actual = testRepository.getCommunities().last()

        Assertions.assertTrue(actual.isNotEmpty())
    }
}