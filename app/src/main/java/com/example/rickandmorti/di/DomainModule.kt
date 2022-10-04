package com.example.rickandmorti.di


import com.example.domain.repository.ICharacterRepository
import com.example.domain.repository.IEpisodesRepository
import com.example.domain.repository.ILocationRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideCharacterListUseCase(repository: ICharacterRepository): GetCharacterListUseCase {
        return GetCharacterListUseCase(repository)
    }

    @Provides
    fun provideCharacterUseCase(repository: ICharacterRepository): GetCharacterUseCase {
        return GetCharacterUseCase(repository)

    }

    @Provides
    fun provideEpisodeListUseCase(repository: IEpisodesRepository): GetEpisodeListUseCase {
        return GetEpisodeListUseCase(repository)
    }
    @Provides
    fun provideEpisodeUseCase(repository: IEpisodesRepository):GetEpisodeDetailUseCase{
        return GetEpisodeDetailUseCase(repository)
    }
    @Provides
    fun provideLocationListUseCase(repository: ILocationRepository):GetLocationListUseCase{
        return GetLocationListUseCase(repository)
    }
    @Provides
    fun provideLocationUseCase(repository: ILocationRepository):GetLocationDetailUseCase{
        return GetLocationDetailUseCase(repository)
    }
}
