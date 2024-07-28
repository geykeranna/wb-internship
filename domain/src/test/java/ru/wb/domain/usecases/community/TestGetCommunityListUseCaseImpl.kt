package ru.wb.domain.usecases.community

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.CommunityRepositoryStubs

class TestGetCommunityListUseCaseImpl {
    private val testRepository = CommunityRepositoryStubs()

    @Test
    fun `should return the same community list data as in repo`() = runTest{
        val useCase = GetCommunityListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertFalse(actual.isEmpty())
    }

    @Test
    fun `should return the same count community list data in list as in repo limit`() = runTest{
        val expectedLimit = 10

        val testRepo = testRepository
        val useCase = GetCommunityListUseCaseImpl(repository = testRepo)
        val actual = useCase.execute(limit = expectedLimit)

        Assertions.assertEquals(expectedLimit, actual.size)
    }
}