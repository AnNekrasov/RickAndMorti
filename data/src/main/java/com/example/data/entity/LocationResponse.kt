package com.example.data.entity

import com.example.domain.IResponse
import com.example.domain.model.LocationDomainModel

data class LocationResponse(
    val id:Int,
    val name:String,
    val type:String,
    val dimension:String,
    val residents:List<String>,
    val url:String,
    val created:String
):IResponse<LocationDomainModel> {
    override fun toDomainObject(): LocationDomainModel {
        return LocationDomainModel(
            id=id,
            name=name,
            type=type,
            dimension=dimension
        )
    }
}
