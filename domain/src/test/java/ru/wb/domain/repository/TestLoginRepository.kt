package ru.wb.domain.repository

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestLoginRepository {
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return state send on phone pin true on right input`() = runTest{
        when(val actual = testRepository.sendOnPhone("+79099099900").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data)
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return state send on phone pin false on false input`() = runTest{
        when(val actual = testRepository.sendOnPhone("89099099900").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data)
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return state check pin true on right input `() = runTest{
        when(val actual = testRepository.checkCode("0000").last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data)
            else -> Assertions.assertTrue(false)
        }
    }

    @Test
    fun `should return auth state for not auth user`() = runTest{
        when(val actual = testRepository.getAuthState().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertTrue(actual.data)
            else -> Assertions.assertTrue(false)
        }
    }
}