package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.CommunityRepositoryStubs

class TestCommunityRepository {
    private val testRepository = CommunityRepositoryStubs()

    @Test
    fun `should return not empty id community data`() = runTest {
        when(val actual = testRepository.getCommunity("1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.id.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty label community data`() = runTest {
        when(val actual = testRepository.getCommunity(id = "1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.label.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty community data list`() = runTest {
        when(val actual = testRepository.getCommunities().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.data.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }
}