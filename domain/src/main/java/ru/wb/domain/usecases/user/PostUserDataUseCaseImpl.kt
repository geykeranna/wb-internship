package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository

internal class PostUserDataUseCaseImpl(
    private val repository: UserRepository
) : PostUserDataUseCase {
    override fun execute(user: UserData): Flow<LoadState<UserData?>> {
        return repository.postUser(userData = user)
    }

    override fun setName(name: String): Flow<LoadState<Boolean>> {
        return repository.setNameUser(name = name)
    }

    override fun setPhone(phone: String): Flow<LoadState<Boolean>> {
        return repository.setPhoneUser(phone = phone)
    }
}