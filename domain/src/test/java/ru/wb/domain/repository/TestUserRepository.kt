package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.UserData
import ru.wb.domain.stabs.UserRepositoryStubs

class TestUserRepository {
    private val testRepository = UserRepositoryStubs()
    private val user = UserData(
        id = "1",
        name = "User",
        icon = null,
        story = false,
        status = false,
        phone = "+79099099900",
        socialMedia = listOf()
    )

    @Test
    fun `should return not empty id user data`() = runTest{
        val actual = testRepository.getUser("1").last()

        Assertions.assertTrue(actual.id.isNotEmpty())
    }

    @Test
    fun `should return not empty first name user data`() = runTest{
        val actual = testRepository.getUser("1").last()

        Assertions.assertTrue(actual.name.isNotEmpty())
    }

    @Test
    fun `should return not empty phone user data`() = runTest{
        val actual = testRepository.getUser("1").last()

        Assertions.assertTrue(actual.phone.isNotEmpty())
    }

    @Test
    fun `should return not empty user data list`() = runTest{
        val actual = testRepository.getUsers().last()

        Assertions.assertTrue(actual.isNotEmpty())
    }

    @Test
    fun `should return state of put user request`() = runTest{
        val actual = testRepository.putUser(user).last()

        Assertions.assertTrue(actual)
    }

    @Test
    fun `should return state of post user request`() = runTest{
        val actual = testRepository.postUser(user).last()

        Assertions.assertTrue(actual)
    }

    @Test
    fun `should return state of handle going event`() = runTest{
        val actual = testRepository.handleGoingEvent("1").last()

        Assertions.assertTrue(actual)
    }
}