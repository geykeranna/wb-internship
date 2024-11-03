package ru.wb.repository.data.api.mappers

internal interface Mapper<SRC, DST> {
    fun transformToDomain(data: SRC): DST

    fun transformToRepository(data: DST): SRC
}