package com.example.domain.repository

import com.example.domain.model.CharacterDomainModel

interface ICharacterRepository {
    suspend fun getCharacterById(id: Int): CharacterDomainModel
    suspend fun getCharacterList(): List<CharacterDomainModel>
    suspend fun getCharacterListByPage(id:Int):List<CharacterDomainModel>
}