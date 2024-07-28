package ru.wb.domain.usecases.event

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.EventData
import ru.wb.domain.model.Location
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

class TestGetEventListUseCaseImpl {
    private val testRepository = mock<EventRepository>()

    @Test
    fun `should return the same event list data as in repo`() = runTest{
        val testData = EventData(
            id = "1",
            name = "Event",
            location = Location.defaultObject,
            date = "",
            tagList = listOf(),
            icon = null,
            active = true,
            description = "description",
            usersList = mutableListOf()
        )
        Mockito.`when`(testRepository.getEvents(EventGetRequest()))
            .thenReturn(listOf(testData))

        val useCase = GetEventListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertFalse(actual.isEmpty())
    }

    @Test
    fun `should return the same count event list limit data in list as in repo `() = runTest{
        val expectedLimit = 10
        val testData = EventData(
            id = "1",
            name = "Event",
            location = Location.defaultObject,
            date = "",
            tagList = listOf(),
            icon = null,
            active = true,
            description = "description",
            usersList = mutableListOf()
        )
        Mockito.`when`(testRepository.getEvents(EventGetRequest(limit = expectedLimit)))
            .thenReturn(List(expectedLimit) { testData })

        val useCase = GetEventListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(limit = expectedLimit)

        Assertions.assertEquals(expectedLimit, actual.size)
    }
}