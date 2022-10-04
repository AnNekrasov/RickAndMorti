package com.example.data.repository

import com.example.data.entity.EpisodesResponse
import com.example.data.entity.LocationListResponse
import com.example.data.entity.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {
    @GET("location")
    suspend fun getListLocation():LocationListResponse
    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): LocationResponse
}