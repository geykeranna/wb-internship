package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestCheckPinCodeUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `show return the same check pin results as in repo`() = runTest{
        val useCase = CheckPinCodeUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("4444")

        Assertions.assertTrue(actual)
    }
}