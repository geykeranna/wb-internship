package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.CommunityRepositoryStubs

class TestGetCommunityListUseCaseImpl {
    private val testRepository = CommunityRepositoryStubs()

    @Test
    fun `should return not empty community list data as in repo`() = runTest{
        val useCase = GetCommunityListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute().last()

        Assertions.assertFalse(actual.data.isEmpty())
    }

    @Test
    fun `should return the same count community data list in list as in repo limit`() = runTest{
        val expectedLimit = 10

        val useCase = GetCommunityListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(limit = expectedLimit).last()

        Assertions.assertEquals(expectedLimit, actual.data.size)
    }
}