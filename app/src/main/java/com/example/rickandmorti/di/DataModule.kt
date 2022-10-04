package com.example.rickandmorti.di

import com.example.data.repository.CharacterApiService
import com.example.data.repository.*
import com.example.domain.repository.ICharacterRepository
import com.example.domain.repository.IEpisodesRepository
import com.example.domain.repository.ILocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class DataModule {
    @Provides
    fun provideCharacterRepository(apiService: CharacterApiService): ICharacterRepository {
        return CharacterRepositoryImpl(apiService)
    }

    @Provides
    fun provideEpisodeRepository(apiService: EpisodesApiService): IEpisodesRepository {
        return EpisodeRepositoryImpl(apiService)

    }
    @Provides
    fun provideLocationRepository(apiService:LocationApiService):ILocationRepository{
        return LocationRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://rickandmortyapi.com/api/")
        .build()
// @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(okHttpClient)
//        .baseUrl("https://rickandmortyapi.com/api/")
//        .build()

    @Provides
    @Singleton
    fun provideCharacterApiService(retrofit: Retrofit): CharacterApiService =
        retrofit.create(CharacterApiService::class.java)

    @Provides
    @Singleton
    fun provideEpisodeApiService(retrofit: Retrofit): EpisodesApiService =
        retrofit.create(EpisodesApiService::class.java)
    @Provides
    @Singleton
    fun provideLocationApiService(retrofit: Retrofit):LocationApiService=
        retrofit.create(LocationApiService::class.java)
}

//    @Provides
//    @Singleton
//    fun provideOkhttp(context: Context):OkHttpClient {
//        OkHttpClient.Builder()
//            .addInterceptor(ChuckerInterceptor(context))
//            .build()
//        return OkHttpClient()
//    }
//
//    @Binds
//    @ApplicationContext
//     fun provideContext(): Context
//}
