package com.example.data.entity

import com.example.domain.IResponse
import com.example.domain.model.LocationDomainModel

data class LocationListResponse(
    val info:InfoResponse,
    val results:List<LocationResponse>
):IResponse <List<LocationDomainModel>> {
    override fun toDomainObject():List<LocationDomainModel> {
        return results.map { it.toDomainObject() }
    }
}
