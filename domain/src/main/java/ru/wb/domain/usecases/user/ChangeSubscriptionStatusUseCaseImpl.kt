package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.UserRepository

internal class ChangeSubscriptionStatusUseCaseImpl(
    private val repository: UserRepository
) : ChangeSubscriptionStatusUseCase {
    override fun execute(idCommunity: String): Flow<Boolean> {
        return repository.changeSubscriptionStatus(idCommunity = idCommunity)
    }
}