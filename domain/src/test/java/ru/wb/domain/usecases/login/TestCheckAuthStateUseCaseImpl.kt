package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestCheckAuthStateUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return the same auth state data as in repo`() = runTest{
        val useCase = CheckAuthStateUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertFalse(actual)
    }
}