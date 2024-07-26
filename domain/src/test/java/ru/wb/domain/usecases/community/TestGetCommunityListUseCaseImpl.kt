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
        Mockito.`when`(testRepository.getCommunities())
            .thenReturn(listOf(testCommunityData))

        val useCase = GetCommunityListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()
        val expected = listOf(CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        ))

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should return the same count community list data in list as in repo limit`() = runTest{
        val testCommunityData = CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        )
        Mockito.`when`(testRepository.getCommunities())
            .thenReturn(List(10) {testCommunityData})

        val testRepo = testRepository
        val useCase = GetCommunityListUseCaseImpl(repository = testRepo)
        val actual = useCase.execute(CommunitiesGetRequest(limit = 10))
        val expected = List(10){ CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        )}

        Assertions.assertEquals(expected, actual)
    }
}