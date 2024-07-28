package ru.wb.domain.usecases.user

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository
import ru.wb.domain.repisotory.model.UsersGetRequest

internal class TestGetUserListUseCaseImpl{
    private val testRepository = mock<UserRepository>()

    @Test
    fun `show return the same list user data as in repo`() = runTest{
        val user = UserData(
            id = "1",
            firstName = "Name",
            lastName = null,
            icon = null,
            story = false,
            status = false,
            phone = "0000000000",
            socialMedia = listOf()
        )
        Mockito.`when`(testRepository.getUsers(UsersGetRequest()))
            .thenReturn(listOf(user))

        val useCase = GetUserListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertTrue(actual.isNotEmpty())
    }

    @Test
    fun `show return the same list limit user data as in repo`() = runTest{
        val expectedLimit = 10
        val user = UserData(
            id = "1",
            firstName = "Name",
            lastName = null,
            icon = null,
            story = false,
            status = false,
            phone = "0000000000",
            socialMedia = listOf()
        )
        Mockito.`when`(testRepository.getUsers(UsersGetRequest(limit = expectedLimit)))
            .thenReturn(List(expectedLimit) { user })

        val useCase = GetUserListUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(limit = expectedLimit)

        Assertions.assertTrue(actual.isNotEmpty())
    }
}
