package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.UserData
import ru.wb.domain.stabs.UserRepositoryStubs

class TestPostUserDataUseCaseImpl {
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `show return results post user as in repo`() = runTest{
        val user = UserData(
            id = "1",
            firstName = "User",
            lastName = "",
            icon = null,
            story = false,
            status = false,
            phone = "+79099099900",
            socialMedia = listOf()
        )

        val useCase = PostUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(user).last()

        Assertions.assertTrue(actual)
    }
}