package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState

interface PostUserDataUseCase {
      fun execute(user: UserData): Flow<LoadState<UserData?>>

      fun setName(name: String): Flow<LoadState<UserData>>

      fun setPhone(phone: String): Flow<LoadState<UserData>>
}