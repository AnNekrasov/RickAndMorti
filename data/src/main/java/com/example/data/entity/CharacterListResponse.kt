package com.example.data.entity

import com.example.domain.IInfoPageResponse
import com.example.domain.IResponse
import com.example.domain.IResponseByPage
import com.example.domain.model.CharacterDomainModel

data class CharacterListResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
) : IResponse<List<CharacterDomainModel>>{
    override fun toDomainObject(): List<CharacterDomainModel> {
        return results.map {
            it.toDomainObject()
        }
    }
//
//    override fun toDomainObjectByPage(page: Int):List<CharacterDomainModel> {
//        return results.map { it.toDomainObject() }
//    }
//
//    override fun getPage(): Int {
//        return info.pages
//    }

}
/*
override fun getPage(): Int {
TODO("Not yet implemented")
}
*/

