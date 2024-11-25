package ru.wb.ui.utils.mappers

internal interface Mapper<SRC, DST> {
    fun transformTo(data: SRC): DST

    fun transformFrom(data: DST): SRC
}