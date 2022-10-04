package com.example.domain.usecase

import com.example.domain.model.CharacterDomainModel
import com.example.domain.model.EpisodesDomainModel
import com.example.domain.repository.ICharacterRepository
import com.example.domain.repository.IEpisodesRepository

class GetEpisodeListUseCase(
  val repository: IEpisodesRepository){
  suspend fun  getEpisodeList():List<EpisodesDomainModel>{
    return repository.getEpisodeList()

  }
}