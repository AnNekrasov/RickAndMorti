package com.example.domain.repository

import com.example.domain.model.LocationDomainModel

interface ILocationRepository {
    suspend fun getLocationList():List<LocationDomainModel>
    suspend fun getLocationByID(id:Int):LocationDomainModel
}