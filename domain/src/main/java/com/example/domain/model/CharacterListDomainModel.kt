package com.example.domain.model

data class CharacterListDomainModel(
    val info: InfoDomainModel,
    val results: List<CharacterDomainModel>
)