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
        val expected = listOf(
            EventData(
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
        )

        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should return the same count event list limit data in list as in repo `() = runTest{
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
        Mockito.`when`(testRepository.getEvents(EventGetRequest(limit = 10)))
            .thenReturn(List(10) { testData })

        val useCase = GetEventListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(limit = 10)
        val expected = List(10) {
            EventData(
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
        }

        Assertions.assertEquals(expected, actual)
    }
}