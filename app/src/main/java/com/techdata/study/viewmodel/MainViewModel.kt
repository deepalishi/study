package com.techdata.study.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techdata.study.data.model.ApiResult
import com.techdata.study.data.model.UsersItem
import com.techdata.study.data.network.RetrofitBuilder
import com.techdata.study.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository = Repository(RetrofitBuilder.apiService)
): ViewModel() {

    val _users = MutableStateFlow<ApiResult<List<UsersItem>>>(ApiResult.Loading)

    val users: StateFlow<ApiResult<List<UsersItem>>> = _users.asStateFlow()

    fun getUsers() {
        viewModelScope.launch {
            repository.users().collect {
                _users.value = it
            }
        }
    }
}