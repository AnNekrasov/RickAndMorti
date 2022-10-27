package com.example.domain.repository

import com.example.domain.model.CharacterDomainModel

interface ICharacterRepository {
    suspend fun getCharacterById(id: Int): CharacterDomainModel
    suspend fun getCharacterList(page: Int): List<CharacterDomainModel>
//    suspend fun getCharacterListByPage(id: Int): List<CharacterDomainModel>
//    suspend fun getPage(page: Int): Int {
//        return page
//    }
}