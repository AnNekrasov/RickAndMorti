package com.example.rickandmorti.presentation.location_flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.LocationDomainModel
import com.example.domain.usecase.GetLocationListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LocationListViewModel  @Inject constructor (
    val getLocationListUseCase: GetLocationListUseCase
):ViewModel() {
    val liveData = MutableLiveData<List<LocationDomainModel>>()
    fun loadLocationList(){
        viewModelScope.launch(Dispatchers.IO) {
            liveData.postValue(getLocationListUseCase.getLocationList())
        }
    }
}