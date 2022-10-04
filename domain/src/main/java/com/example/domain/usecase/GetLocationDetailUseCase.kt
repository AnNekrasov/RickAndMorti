package com.example.domain.usecase

import com.example.domain.model.LocationDomainModel
import com.example.domain.repository.ILocationRepository

class GetLocationDetailUseCase(
    val repository: ILocationRepository
) {
    suspend fun getLocationByID(id:Int):LocationDomainModel{
        return repository.getLocationByID(id)
    }
}