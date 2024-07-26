package ru.wb.domain.usecases.event

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.EventData
import ru.wb.domain.model.Location
import ru.wb.domain.repisotory.EventRepository

class TestGetEventDataUseCaseImpl{
    private val testRepository = mock<EventRepository>()

    @Test
    fun `should return the same event data as in repo`() = runTest {
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
        Mockito.`when`(testRepository.getEvent("1"))
            .thenReturn(testData)

        val useCase = GetEventDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(id = "1")
        val expected = EventData(
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

        Assertions.assertEquals(expected, actual)
    }
}