package com.example.rickandmorti.presentation.episodes_flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.EpisodesDomainModel
import com.example.domain.usecase.GetEpisodeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private  val getEpisodeDetailUseCase: GetEpisodeDetailUseCase)
    :ViewModel(){
        val liveData=MutableLiveData<EpisodesDomainModel>()

    fun loadEpisode(id :Int){
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(getEpisodeDetailUseCase.getEpisode(id))
        }
    }
}