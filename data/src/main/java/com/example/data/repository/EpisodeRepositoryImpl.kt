package com.example.data.repository

import com.example.domain.model.EpisodesDomainModel
import com.example.domain.repository.IEpisodesRepository

class EpisodeRepositoryImpl(
    private val apiService: EpisodesApiService
) : IEpisodesRepository {
    override suspend fun getEpisodeByID(id: Int): EpisodesDomainModel {
        return apiService.getEpisodeById(id).toDomainObject()
    }

    override suspend fun getEpisodeList(): List<EpisodesDomainModel> {
        return apiService.getListEpisode().toDomainObject()

    }
}
