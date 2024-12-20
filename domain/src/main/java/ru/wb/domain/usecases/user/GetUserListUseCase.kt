package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserResponse

interface GetUserListUseCase {
      fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        communityId: String? = null,
        eventId: String? = null,
    ): Flow<LoadState<UserResponse>>
}