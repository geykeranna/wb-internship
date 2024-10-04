package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.community.CommunityRepository

internal class PostSubscribeOnCommunityImpl(
    private val repository: CommunityRepository
): PostSubscribeOnCommunity {
    override fun execute(
        idUser: String,
        idCommunity: String,
    ): Flow<LoadState<Boolean>> = repository.subscribeOnCommunity(
        idUser = idUser,
        idCommunity = idCommunity,
    )
}