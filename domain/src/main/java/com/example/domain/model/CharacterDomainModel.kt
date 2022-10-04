package com.example.domain.model

data class CharacterDomainModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val imageUrl: String,
    val location:LocationNameDomainModel

)

