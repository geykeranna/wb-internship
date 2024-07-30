package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.UserRepository

internal class GetUserDataUseCaseImpl(
    private val repository: UserRepository
) : GetUserDataUseCase {
    override fun execute(id: String): Flow<UserData> = repository.getUser(id = id)
}