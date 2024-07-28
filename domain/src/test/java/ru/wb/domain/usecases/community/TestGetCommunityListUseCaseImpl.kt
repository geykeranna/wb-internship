package ru.wb.domain.usecases.community

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

class TestGetCommunityListUseCaseImpl {
    private val testRepository = mock<CommunityRepository>()

    @Test
    fun `should return the same community list data as in repo`() = runTest{
        val testCommunityData = CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        )
        Mockito.`when`(testRepository.getCommunities(CommunitiesGetRequest()))
            .thenReturn(listOf(testCommunityData))

        val useCase = GetCommunityListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertFalse(actual.isEmpty())
    }

    @Test
    fun `should return the same count community list data in list as in repo limit`() = runTest{
        val expectedLimit = 10
        val testCommunityData = CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        )
        Mockito.`when`(testRepository.getCommunities(CommunitiesGetRequest(limit = expectedLimit)))
            .thenReturn(List(expectedLimit) {testCommunityData})

        val testRepo = testRepository
        val useCase = GetCommunityListUseCaseImpl(repository = testRepo)
        val actual = useCase.execute(limit = expectedLimit)

        Assertions.assertEquals(expectedLimit, actual.size)
    }
}