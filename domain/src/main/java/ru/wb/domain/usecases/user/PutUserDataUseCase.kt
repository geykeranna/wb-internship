package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState

interface PutUserDataUseCase {
      fun execute(user: UserData): Flow<LoadState<UserData?>>
}