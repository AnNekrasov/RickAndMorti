package com.example.data.entity

import com.example.domain.IResponse
import com.example.domain.model.EpisodesDomainModel
import com.example.domain.model.EpisodesListDomainModel

data class
EpisodesListResponse(
    val info: InfoResponse,
    val results: List<EpisodesResponse>
) : IResponse<List<EpisodesDomainModel>> {
    override fun toDomainObject(): List<EpisodesDomainModel> {
        return results.map { it.toDomainObject() }
    }
}


