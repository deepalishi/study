package com.techdata.study.data.network

import com.techdata.study.data.model.UsersItem
import retrofit2.http.GET

interface ApiService {

    @GET
    suspend fun users(): List<UsersItem>
}