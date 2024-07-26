package ru.wb.domain.usecases.user

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

class TestHandleGoingEventImpl {
    private val testRepository = mock<UserRepository>()

    @Test
    fun `show return results handle change status going on event as in repo`() = runTest{

        Mockito.`when`(testRepository.handleGoingEvent("1"))
            .thenReturn(true)

        val useCase = HandleGoingEventImpl(repository = testRepository)
        val actual = useCase.execute("1")
        val expected = true

        Assertions.assertEquals(expected, actual)
    }
}