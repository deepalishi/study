package com.techdata.study.data.repository

import com.techdata.study.data.model.ApiResult
import com.techdata.study.data.model.UsersItem
import com.techdata.study.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(val apiService: ApiService) {

    fun users(): Flow<ApiResult<List<UsersItem>>> = flow {
        try {
            emit(ApiResult.Loading)
            val data = apiService.users()
            emit(ApiResult.Success(data))
        } catch (e: Exception) {
            //emit(ApiResult.Error(e.localizedMessage ?: ""))
        }
    }
}