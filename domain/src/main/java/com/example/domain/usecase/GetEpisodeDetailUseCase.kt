package com.example.domain.usecase

import com.example.domain.model.CharacterDomainModel
import com.example.domain.model.EpisodesDomainModel
import com.example.domain.repository.ICharacterRepository
import com.example.domain.repository.IEpisodesRepository

class GetEpisodeDetailUseCase (
    val repository: IEpisodesRepository
) {
    suspend  fun getEpisode(
        id: Int
    ): EpisodesDomainModel {
        return repository.getEpisodeByID(id)
    }
}