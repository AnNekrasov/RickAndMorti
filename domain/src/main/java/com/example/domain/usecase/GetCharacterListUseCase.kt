package com.example.domain.usecase

import com.example.domain.model.CharacterDomainModel
import com.example.domain.repository.ICharacterRepository

class GetCharacterListUseCase(
    val repository: ICharacterRepository
) {
    suspend fun getCharacterList(): List<CharacterDomainModel> {
        return repository.getCharacterList()
//    }
    }
    suspend fun getCharacterListByPage(page:Int):List<CharacterDomainModel> {
        return repository.getCharacterListByPage(page)
    }
}