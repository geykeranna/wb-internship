package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData

interface PostUserDataUseCase {
      fun execute(user: UserData): Flow<UserData?>
}