package com.example.data.repository

import com.example.domain.model.CharacterDomainModel
import com.example.domain.repository.ICharacterRepository

class CharacterRepositoryImpl(
    private val apiService: CharacterApiService
) : ICharacterRepository {
    override suspend fun getCharacterById(id:Int): CharacterDomainModel {
        return  apiService.getCharacterById(id).toDomainObject()
    }

    override suspend fun getCharacterList(page: Int): List<CharacterDomainModel> {
        return apiService.getListCharacter(page).toDomainObject()
    }
//    override suspend fun getCharacterListByPage(page:Int): List<CharacterDomainModel> {
//        return apiService.getListCharacterByPage(page).toDomainObject()
//    }
}
