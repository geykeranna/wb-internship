package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.CommunityRepositoryStubs

class TestGetCommunityDataUseCaseImpl {
    private val testRepository = CommunityRepositoryStubs()

    @Test
    fun `should return not empty id community data as in repo`() = runTest {
        val useCase = GetCommunityDataUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute(id = "1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.id.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty label community data as in repo`() = runTest {
        val useCase = GetCommunityDataUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute(id = "1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.label.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty description community data as in repo`() = runTest {
        val useCase = GetCommunityDataUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute(id = "1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.description.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }
}