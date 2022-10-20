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
   // val listData = Pager(PagingConfig(pageSize = 1))
    val liveData = MutableLiveData<List<CharacterDomainModel>>()
     fun loadCharacterList(){
        viewModelScope.launch(Dispatchers.IO){
            liveData.postValue(getCharacterListUseCase.getCharacterList())
        }
    }
    fun loadCharacterByPage(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(getCharacterListUseCase.getCharacterListByPage(id))
        }
    }
}
//@HiltViewModel
//class CharacterViewModel
//@Inject
//constructor(
//    private val apiService: CharacterApiService
//) : ViewModel() {
//
//    val listData = Pager(PagingConfig(pageSize = 1)) {
//        CharacterListPaging(apiService)
//
//    }.flow.cachedIn(viewModelScope)
//
//}

