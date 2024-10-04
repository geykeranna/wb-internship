package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState

interface PostSubscribeOnCommunity {
    fun execute(
        idUser: String,
        idCommunity: String,
    ): Flow<LoadState<Boolean>>
}