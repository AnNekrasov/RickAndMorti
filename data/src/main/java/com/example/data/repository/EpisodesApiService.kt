package com.example.data.repository

import com.example.data.entity.EpisodesListResponse
import com.example.data.entity.EpisodesResponse
import com.example.domain.model.EpisodesDomainModel
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodesApiService {
    @GET("episode")
    suspend fun getListEpisode():EpisodesListResponse
    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int):EpisodesResponse
}