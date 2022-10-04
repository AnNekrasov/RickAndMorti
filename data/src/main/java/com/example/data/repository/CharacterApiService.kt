package com.example.data.repository

import com.example.data.entity.CharacterListResponse
import com.example.data.entity.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    //https://rickandmortyapi.com/api

    @GET("character")
    suspend fun getListCharacter(): CharacterListResponse

    //  suspend fun getListCharacter(@Query("page")page:Int): CharacterListResponse
//
    @GET("character")
    suspend fun getListCharacterByPage(
        // @Query("count") size:Int,
        @Query("page") page: Int

    ): Response<CharacterListResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterResponse
}