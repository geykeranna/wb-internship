package ru.wb.domain.model.components

sealed class LoadState<out T>{
    data class Error(val error: Errors): LoadState<Nothing>()
    data class Success<out T>(val data: T) : LoadState<T>()
    data object Loading : LoadState<Nothing>()
}