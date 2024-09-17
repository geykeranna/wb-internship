package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserResponse
import ru.wb.domain.repository.user.UsersGetRequest

internal class GetUserListUseCaseImpl(
    private val repository: UserRepository
) : GetUserListUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
        communityId: String?,
        eventId: String?,
    ): Flow<UserResponse> = repository.getUsers(
        UsersGetRequest(
            limit = limit,
            offset = offset,
            query = query,
            communityId = communityId,
            eventId = eventId,
        )
    )
}