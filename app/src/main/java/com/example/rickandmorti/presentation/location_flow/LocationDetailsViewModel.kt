package com.example.rickandmorti.presentation.location_flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.LocationDomainModel
import com.example.domain.usecase.GetLocationDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailsViewModel @Inject constructor(
    private val getLocationDetailUseCase: GetLocationDetailUseCase
):ViewModel() {
    val  liveData = MutableLiveData<LocationDomainModel>()
    fun loadLocation(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(getLocationDetailUseCase.getLocationByID(id))
        }
    }
}