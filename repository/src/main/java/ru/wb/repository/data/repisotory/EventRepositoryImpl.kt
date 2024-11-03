package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import ru.wb.domain.model.EventData
import ru.wb.domain.model.components.Errors
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.event.EventRepository
import ru.wb.domain.repository.event.EventGetRequest
import ru.wb.domain.repository.event.EventGetResponse
import ru.wb.repository.data.api.mappers.models.EventMapper
import ru.wb.repository.data.api.mappers.request.EventGetRequestMapper
import ru.wb.repository.data.api.mappers.response.EventGetResponseMapper
import ru.wb.repository.data.api.services.event.EventService

internal class EventRepositoryImpl(
    private val api: EventService,
    private val eventMapper: EventMapper,
    private val getResponseMapper: EventGetResponseMapper,
    private val getRequestMapper: EventGetRequestMapper,
): EventRepository {
    override fun getEvents(
        request: EventGetRequest?,
    ): Flow<LoadState<EventGetResponse>>{
        return flow {
            val requestData = request?.let { getRequestMapper.transformToRepository(it) }
            val response = getResponseMapper.transformToDomain(api.getEvents(requestData))
            emit(LoadState.Success(response) as LoadState<EventGetResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getEvent(
        id: String,
    ): Flow<LoadState<EventData>> {
        return flow {
            val response = eventMapper.transformToDomain(api.getEvent(id = id))
            emit(LoadState.Success(response) as LoadState<EventData>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }
}