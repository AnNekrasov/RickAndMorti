package com.example.rickandmorti.presentation.character_flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CharacterDomainModel
import com.example.domain.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {
    val liveData = MutableLiveData<CharacterDomainModel>()

    fun loadCharacter(id:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(getCharacterUseCase.getCharacter(id))
        }
    }
}