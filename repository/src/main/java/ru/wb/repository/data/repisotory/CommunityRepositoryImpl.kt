package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.components.Errors
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.repository.community.CommunityGetResponse
import ru.wb.repository.data.api.mappers.request.CommunityGetRequestMapper
import ru.wb.repository.data.api.mappers.response.CommunityGetResponseMapper
import ru.wb.repository.data.api.model.Community
import ru.wb.repository.data.api.services.community.CommunityService
import ru.wb.repository.data.api.services.event.EventGetRequest
import ru.wb.repository.data.api.services.event.EventService

internal class CommunityRepositoryImpl(
    private val api: CommunityService,
    private val eventApi: EventService,
    private val getRequestMapper: CommunityGetRequestMapper,
    private val getResponseMapper: CommunityGetResponseMapper,
): CommunityRepository {
    override fun getCommunities(
        request: CommunitiesGetRequest?
    ): Flow<LoadState<CommunityGetResponse>> {
        return flow {
            val getRequest = request?.let { getRequestMapper.transformToRepository(request) }
            val communityResponse = getResponseMapper.transformToDomain(
                api.getCommunities(getRequest)
            )
            emit(LoadState.Success(communityResponse) as LoadState<CommunityGetResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getCommunity(
        id: String
    ): Flow<LoadState<CommunityData>> {
        return flow {
            var communityData: Community? = null
            api.getCommunity(id = id)?.let { item ->
                communityData = item
            }
            eventApi.getEvents(EventGetRequest(
                idCommunity = id,
                type = ""
            ))
            emit(LoadState.Success(communityData) as LoadState<CommunityData>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }
}