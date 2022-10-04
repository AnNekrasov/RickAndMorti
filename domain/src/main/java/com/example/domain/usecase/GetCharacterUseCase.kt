package com.example.domain.usecase

import com.example.domain.model.CharacterDomainModel
import com.example.domain.repository.ICharacterRepository

class GetCharacterUseCase(
    val repository: ICharacterRepository
) {
  suspend  fun getCharacter(
        id: Int
    ): CharacterDomainModel {
        return repository.getCharacterById(id)
    }
}