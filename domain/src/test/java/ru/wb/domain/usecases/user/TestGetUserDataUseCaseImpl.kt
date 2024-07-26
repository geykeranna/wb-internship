package ru.wb.domain.usecases.user

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

class TestGetUserDataUseCaseImpl{
    private val testRepository = mock<UserRepository>()

    @Test
    fun `show return the same user data as in repo`() = runTest{
        val user = UserData(
            id = "1",
            firstName = "",
            lastName = "",
            icon = "",
            story = null,
            status = null,
            phone = "",
            socialMedia = listOf()
        )
        Mockito.`when`(testRepository.getUser("1"))
            .thenReturn(user)

        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("1")
        val expected = UserData(
            id = "1",
            firstName = "",
            lastName = "",
            icon = "",
            story = null,
            status = null,
            phone = "",
            socialMedia = listOf()
        )

        Assertions.assertEquals(expected, actual)
    }
}