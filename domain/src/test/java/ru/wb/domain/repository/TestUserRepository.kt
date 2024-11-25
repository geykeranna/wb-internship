package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserSubscribeStatusResponse
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
        when(val actual = testRepository.getUser("1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.id.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty first name user data`() = runTest{
        when(val actual = testRepository.getUser("1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.name.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty phone user data`() = runTest{
        when(val actual = testRepository.getUser("1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.phone.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return not empty user data list`() = runTest{
        when(val actual = testRepository.getUsers().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data.data.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return state of put user request`() = runTest{
        when(val actual = testRepository.putUser(user).last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data != null && actual.data!!.id.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return state of post user request`() = runTest{
        when(val actual = testRepository.postUser(user).last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data != null && actual.data!!.id.isNotEmpty())
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return state of handle going event`() = runTest{
        when(val actual = testRepository.changeSubscriptionEventStatus("1").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(
                actual.data == UserSubscribeStatusResponse.SUBSCRIBED
            )
            else -> Assertions.assertTrue(false)
        }
    }
}