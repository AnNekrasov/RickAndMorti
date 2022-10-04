package com.example.rickandmorti.presentation.episodes_flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.EpisodesDomainModel
import com.example.domain.usecase.GetEpisodeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class EpisodesListViewModel @Inject constructor(
    private val getEpisodeListUseCase: GetEpisodeListUseCase
):ViewModel(){
    val liveData=MutableLiveData<List<EpisodesDomainModel>>()
    fun loadEpisodeList(){
        viewModelScope.launch (Dispatchers.IO){
            liveData.postValue(getEpisodeListUseCase.getEpisodeList())
        }
    }
}