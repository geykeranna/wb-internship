package ru.wb.domain.usecases.user

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class TestGetUserListUseCaseImpl{
    private val testRepository = mock<UserRepository>()

    @Test
    fun `show return the same list user data as in repo`() = runTest{
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
        Mockito.`when`(testRepository.getUsers())
            .thenReturn(listOf(user))

        val useCase = GetUserListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()
        val expected = listOf(UserData(
            id = "1",
            firstName = "",
            lastName = "",
            icon = "",
            story = null,
            status = null,
            phone = "",
            socialMedia = listOf()
        ))

        Assertions.assertEquals(expected, actual)
    }
}
