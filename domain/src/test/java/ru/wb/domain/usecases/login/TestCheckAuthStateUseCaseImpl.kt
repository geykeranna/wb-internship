package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestCheckAuthStateUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return the same auth state data as in repo`() = runTest{
        val useCase = CheckAuthStateUseCaseImpl(repository = testRepository)

        when(val actual = useCase.execute().last()) {
            is LoadState.Loading -> Assertions.assertTrue(true)
            is LoadState.Success -> Assertions.assertFalse(actual.data)
            else -> Assertions.assertTrue(false)
        }
    }
}