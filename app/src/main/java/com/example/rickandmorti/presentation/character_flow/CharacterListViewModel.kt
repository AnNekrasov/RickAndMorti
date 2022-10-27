package com.example.rickandmorti.presentation.character_flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CharacterDomainModel
import com.example.domain.usecase.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel

class CharacterListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
):ViewModel() {

    val liveData = MutableLiveData<List<CharacterDomainModel>>()
    fun loadCharacterList(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(getCharacterListUseCase.getCharacterList(page))
        }
    }
}
