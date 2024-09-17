package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.UserData
import ru.wb.domain.stabs.UserRepositoryStubs

class TestPutUserDataUseCaseImpl {
    private val testRepository = UserRepositoryStubs()

    @Test
    fun `should return results put user as in repo`() = runTest{
        val user = UserData(
            id = "1",
            name = "",
            icon = "",
            story = false,
            status = false,
            phone = "",
            socialMedia = listOf()
        )

        val useCase = PutUserDataUseCaseImpl(repository = testRepository)
        val actual = useCase.execute(user).last()

        Assertions.assertTrue(actual?.id?.isNotEmpty() ?: false)
    }
}