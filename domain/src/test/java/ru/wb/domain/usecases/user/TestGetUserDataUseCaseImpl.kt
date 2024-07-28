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
            firstName = "Name",
            lastName = null,
            icon = null,
            story = false,
            status = false,
            phone = "0000000000",
            socialMedia = listOf()
        )
        Mockito.`when`(testRepository.getUser("1"))
            .thenReturn(user)

        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("1")

        if (actual != null) {
            Assertions.assertTrue(
                actual.id.isNotEmpty()
                && actual.firstName.isNotEmpty()
                && actual.phone.isNotEmpty()
            )
        }
    }

    @Test
    fun `show return null with null id as in repo`() = runTest{
        val useCase = GetUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(null)

        Assertions.assertEquals(null, actual)
    }
}