package com.example.domain.usecase

import com.example.domain.model.LocationDomainModel
import com.example.domain.repository.ILocationRepository

class GetLocationListUseCase(
    val repository: ILocationRepository
) {

    suspend fun getLocationList():List<LocationDomainModel>{
        return repository.getLocationList()
    }
}