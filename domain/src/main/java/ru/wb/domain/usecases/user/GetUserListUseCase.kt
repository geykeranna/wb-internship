package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData

interface GetUserListUseCase {
    suspend fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        communityId: String? = null,
        eventId: String? = null,
    ): List<UserData>
}