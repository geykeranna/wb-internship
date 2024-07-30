package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.wb.domain.stabs.LoginRepositoryStubs

class TestCheckPinCodeUseCaseImpl{
    private val testRepository = LoginRepositoryStubs()

    @Test
    fun `should return the same check pin status as in repo`() = runTest{
        val useCase = CheckPinCodeUseCaseImpl(repository = testRepository)
        val actual = useCase.execute("4444").last()

        Assertions.assertTrue(actual)
    }
}