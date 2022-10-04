package com.example.data.entity

import com.example.domain.IResponse
import com.example.domain.model.EpisodesDomainModel

data class EpisodesResponse(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
) : IResponse<EpisodesDomainModel> {
    override fun toDomainObject(): EpisodesDomainModel {
        return EpisodesDomainModel(
            id = id,
            name = name,
            airdate = air_date,
            episode = episode
//            url = url,
//            created = created,
        )
    }
}
