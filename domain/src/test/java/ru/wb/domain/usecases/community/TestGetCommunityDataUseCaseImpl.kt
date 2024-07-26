package ru.wb.domain.usecases.community

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository

class TestGetCommunityDataUseCaseImpl {
    private val testRepository = mock<CommunityRepository>()

    @Test
    fun `should return the same community data as in repo`() = runTest {

        val testCommunityData = CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        )
        Mockito.`when`(testRepository.getCommunity("1"))
            .thenReturn(testCommunityData)

        val useCase = GetCommunityDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(id = "1")
        val expected = CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        )

        Assertions.assertEquals(expected, actual)
    }
}