package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class GetUserDataUseCaseImpl(
    private val repository: UserRepository
) : GetUserDataUseCase {
    override suspend fun execute(id: String?): Flow<UserData?> {
        id?.let { userId ->
            return repository.getUser(id = userId)
        }
        return flowOf(null)
    }
}