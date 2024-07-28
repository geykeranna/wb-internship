package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository
import ru.wb.domain.repisotory.model.UsersGetRequest

internal class GetUserListUseCaseImpl(
    private val repository: UserRepository
) : GetUserListUseCase {
    override suspend fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
        communityId: String?,
        eventId: String?,
    ): Flow<List<UserData>> = repository.getUsers(UsersGetRequest(
        limit = limit,
        offset = offset,
        query = query,
        communityId = communityId,
        eventId = eventId,
    ))
}