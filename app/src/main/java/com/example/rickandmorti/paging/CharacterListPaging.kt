package com.example.rickandmorti.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.entity.CharacterResponse
import com.example.data.repository.CharacterApiService
import com.example.domain.IResponse
import com.example.domain.model.CharacterDomainModel
import com.example.domain.usecase.GetCharacterListUseCase
import java.lang.Exception

//class CharacterListPaging(private val getCharacterListUseCase
//: GetCharacterListUseCase):PagingSource<Int,CharacterDomainModel>() {
//    override fun getRefreshKey(state: PagingState<Int, CharacterDomainModel>): Int? {
//        return null
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDomainModel> {
//        return try {
//            val currentPage = params.key ?: 1
//            val response = getCharacterListUseCase.getCharacterList(currentPage)
//            val responseData = mutableListOf<CharacterDomainModel>()
//            val data = response.body()?.results ?: emptyList()
//            responseData.addAll(data)
//
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (currentPage == 1) null else -1,
//                nextKey = currentPage.plus(1)
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//
//    }
//}
//
//class CharacterListPaging(private val apiService: CharacterApiService) :
//    PagingSource<Int, CharacterDomainModel>() {
//    override fun getRefreshKey(state: PagingState<Int, CharacterDomainModel>): Int? {
//        return null
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDomainModel> {
//        return try {
//            val currentPage = params.key ?: 1
//            val response = apiService.getListCharacterByPage(currentPage)
//            val responseData = mutableListOf<CharacterDomainModel>()
//            val data = response.body()?.results?.map {
//                it.toDomainObject()
//            }
//
//
//            //  val data = response.body()?results.?: emptyList()
//            if (data != null) {
//                responseData.addAll(data)
//            }
//
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (currentPage == 1) null else -1,
//                nextKey = currentPage.plus(1)
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }
//}
//
//
