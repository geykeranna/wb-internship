package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.model.components.Errors
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.common.CommonRepository
import ru.wb.domain.repository.common.ContentGetRequest
import ru.wb.domain.repository.common.ContentGetResponse
import ru.wb.repository.data.api.mappers.models.CountryCodesMapper
import ru.wb.repository.data.api.mappers.models.SocialMediaMapper
import ru.wb.repository.data.api.mappers.request.ContentGetRequestMapper
import ru.wb.repository.data.api.mappers.response.ContentGetResponseMapper
import ru.wb.repository.data.api.services.common.CommonService

internal class CommonRepositoryImpl(
    private val api: CommonService,
    private val socialMediaMapper: SocialMediaMapper,
    private val countryCodesMapper: CountryCodesMapper,
    private val contentGetResponseMapper: ContentGetResponseMapper,
    private val contentGetRequestMapper: ContentGetRequestMapper,
): CommonRepository {
    override fun getContent(request: ContentGetRequest): Flow<LoadState<ContentGetResponse>> {
        return flow {
            val requestData = contentGetRequestMapper.transformToRepository(request)
            val response = contentGetResponseMapper.transformToDomain(
                api.getContent(data = requestData)
            )
            emit(LoadState.Success(response) as LoadState<ContentGetResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getSocialMediaList(type: String): Flow<LoadState<List<SocialMedia>>> {
        return flow {
            val response = api.getSocialMediaList(type = type).map {
                socialMediaMapper.transformToDomain(it)
            }
            emit(LoadState.Success(response) as LoadState<List<SocialMedia>>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getCountryCodesList(type: String): Flow<LoadState<List<CountryCodes>>> {
        return flow {
            val response = api.getCountryCodesList(type = type).map {
                countryCodesMapper.transformToDomain(it)
            }
            emit(LoadState.Success(response) as LoadState<List<CountryCodes>>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getChipsInterest(type: String): Flow<LoadState<List<String>>> {
        return flow {
            val response = api.getChipsInterest(type = type)
            emit(LoadState.Success(response) as LoadState<List<String>>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun setChipsInterest(chips: List<String>): Flow<LoadState<Boolean>> {
        return flow {
            emit(LoadState.Success(true) as LoadState<Boolean>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }
}