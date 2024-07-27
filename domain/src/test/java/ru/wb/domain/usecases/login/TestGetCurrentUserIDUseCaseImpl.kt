package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.repisotory.LoginRepository

class TestGetCurrentUserIDUseCaseImpl{
    private val testRepository = mock<LoginRepository>()

    @Test
    fun `should return the same auth user id data as in repo`() = runTest{
        Mockito.`when`(testRepository.getUserID())
            .thenReturn("1")

        val useCase = GetCurrentUserIDUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()
        val expected = "1"

        Assertions.assertEquals(expected, actual)
    }
}