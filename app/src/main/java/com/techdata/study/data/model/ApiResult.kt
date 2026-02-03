package com.techdata.study.data.model

sealed class ApiResult<out T> {
    object Loading: ApiResult<Nothing>()
    class Success<T>(val data: T): ApiResult<T>()
    data class Error(val errorMessage: Int): ApiResult<Nothing>()
}
