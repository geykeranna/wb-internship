package ru.wb.domain.usecases.user

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

class TestPutUserDataUseCaseImpl {
    private val testRepository = mock<UserRepository>()

    @Test
    fun `show return results put user as in repo`() = runTest{
        val user = UserData(
            id = "1",
            firstName = "",
            lastName = "",
            icon = "",
            story = false,
            status = false,
            phone = "",
            socialMedia = listOf()
        )
        Mockito.`when`(testRepository.putUser(user))
            .thenReturn(true)

        val useCase = PutUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(user)

        Assertions.assertTrue(actual)
    }
}