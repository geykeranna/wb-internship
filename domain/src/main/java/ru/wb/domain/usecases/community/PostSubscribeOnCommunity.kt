package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.ResultResponse

interface PostSubscribeOnCommunity {
    fun execute(
        idUser: String,
        idCommunity: String,
    ): Flow<ResultResponse>
}