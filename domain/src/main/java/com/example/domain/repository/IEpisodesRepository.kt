package com.example.domain.repository

import com.example.domain.model.EpisodesDomainModel

interface IEpisodesRepository {
    suspend fun getEpisodeByID(id:Int):EpisodesDomainModel
    suspend fun getEpisodeList():List<EpisodesDomainModel>
}