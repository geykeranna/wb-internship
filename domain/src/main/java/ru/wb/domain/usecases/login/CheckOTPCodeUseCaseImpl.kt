package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.LoginRepository

internal class CheckOTPCodeUseCaseImpl(
    private val repository: LoginRepository
) : CheckOTPCodeUseCase {
    override fun execute(pin: String): Flow<LoadState<String>> {
        return repository.checkCode(pinCode = pin)
    }
}