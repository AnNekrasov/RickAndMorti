package com.example.domain

interface IResponse<T> {
    fun toDomainObject():T
  //  fun getPage():Int
}
