package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestLoginRepository {
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return state send on phone pin true on right input`() = runTest{
        val actual = testRepository.sendOnPhone("+79099099900").last()

        Assertions.assertTrue(actual)
    }

    @Test
    fun `should return state send on phone pin false on false input`() = runTest{
        val actual = testRepository.sendOnPhone("89099099900").last()

        Assertions.assertFalse(actual)
    }

    @Test
    fun `should return state check pin true on right input `() = runTest{
        val actual = testRepository.checkCode("0000").last()

        Assertions.assertTrue(actual)
    }

    @Test
    fun `should return auth state for not auth user`() = runTest{
        val actual = testRepository.getAuthState().last()

        Assertions.assertFalse(actual)
    }
    @Test
    fun `should return not empty user id`() = runTest{
        val actual = testRepository.getUserID().last()

        Assertions.assertTrue(actual.isNotEmpty())
    }
}