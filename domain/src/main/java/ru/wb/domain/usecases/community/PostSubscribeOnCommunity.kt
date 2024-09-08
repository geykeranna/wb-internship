package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow

interface PostSubscribeOnCommunity {
    fun execute(
        idUser: String,
        idCommunity: String,
    ): Flow<Boolean>
}