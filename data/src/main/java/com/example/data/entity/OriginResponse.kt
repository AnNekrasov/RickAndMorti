package com.example.data.entity

import com.example.domain.IResponse

data class OriginResponse(
    val name: String,
    val url: String
) : IResponse<OriginResponse> {
    override fun toDomainObject(): OriginResponse {
        return OriginResponse(
            name = name,
            url = url
        )
    }
}
