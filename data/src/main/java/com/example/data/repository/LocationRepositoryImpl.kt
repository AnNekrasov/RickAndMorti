package com.example.data.repository

import com.example.domain.model.LocationDomainModel
import com.example.domain.repository.ILocationRepository

class LocationRepositoryImpl(
    val apiService: LocationApiService
):ILocationRepository {
    override suspend fun getLocationList():List<LocationDomainModel> {
       return apiService.getListLocation().toDomainObject()
    }

    override suspend fun getLocationByID(id: Int):LocationDomainModel {
        return apiService.getLocationById(id).toDomainObject()
    }
}