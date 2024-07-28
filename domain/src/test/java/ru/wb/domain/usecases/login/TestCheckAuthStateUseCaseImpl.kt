package ru.wb.domain.usecases.login

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import ru.wb.domain.repisotory.LoginRepository

class TestCheckAuthStateUseCaseImpl{
    private val testRepository = mock<LoginRepository>()

    @Test
    fun `should return the same auth state data as in repo`() = runTest{
        Mockito.`when`(testRepository.getAuthState())
            .thenReturn(false)

        val useCase = CheckAuthStateUseCaseImpl(repository = testRepository)
        val actual = useCase.execute()

        Assertions.assertFalse(actual)
    }
}