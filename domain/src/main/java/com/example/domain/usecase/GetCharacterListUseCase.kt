package com.example.domain.usecase

import com.example.domain.model.CharacterDomainModel
import com.example.domain.repository.ICharacterRepository

class GetCharacterListUseCase(
    val repository: ICharacterRepository
)
{
    suspend fun getCharacterList(page: Int): List<CharacterDomainModel> {
        return repository.getCharacterList(page)
//    }
    }
}
//    suspend fun getCharacterListByPage(page:Int):List<CharacterDomainModel> {
//        return repository.getCharacterListByPage(page)
//    }
//    suspend fun getPage(page: Int):Int{
//        return repository.getPage(page)
//    }
//}