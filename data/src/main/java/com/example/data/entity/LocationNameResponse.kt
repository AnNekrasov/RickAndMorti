package com.example.data.entity

import com.example.domain.IResponse
import com.example.domain.model.LocationNameDomainModel

data class LocationNameResponse(
    val name: String,
    val url: String
) : IResponse<LocationNameDomainModel> {
    override fun toDomainObject(): LocationNameDomainModel {
        return LocationNameDomainModel(
            name = name,
            url = url
        )
    }
}


