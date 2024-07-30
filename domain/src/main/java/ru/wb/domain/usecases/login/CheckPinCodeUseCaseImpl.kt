package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.LoginRepository

internal class CheckPinCodeUseCaseImpl(
    private val repository: LoginRepository
) : CheckPinCodeUseCase {
    override fun execute(
        pin: String
    ): Flow<Boolean> = repository.checkCode(pinCode = pin)
}