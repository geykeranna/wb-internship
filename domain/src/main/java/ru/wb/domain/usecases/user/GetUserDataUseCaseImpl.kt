package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository

internal class GetUserDataUseCaseImpl(
    private val repository: UserRepository
) : GetUserDataUseCase {
    override fun execute(id: String?): Flow<LoadState<UserData>>{
        return repository.getUser(id = id)
    }

    override fun getName(): Flow<LoadState<String>> {
        return repository.getNameUser()
    }

    override fun getPhone(): Flow<LoadState<String>> {
        return repository.getPhoneUser()
    }
}