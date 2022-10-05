package com.example.data.entity

import com.example.domain.IResponse
import com.example.domain.model.CharacterDomainModel

data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginResponse,
    val location: LocationNameResponse,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) : IResponse<CharacterDomainModel> {

    override fun toDomainObject(): CharacterDomainModel {
        return CharacterDomainModel(
            id = id,
            name = name,
            status = status,
            species = species,
            gender = gender,
            imageUrl = image,
            location = location.toDomainObject()//123


        )
    }
}