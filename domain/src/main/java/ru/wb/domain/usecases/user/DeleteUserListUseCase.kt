package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState

interface DeleteUserListUseCase {
      fun execute(): Flow<LoadState<Boolean>>
}