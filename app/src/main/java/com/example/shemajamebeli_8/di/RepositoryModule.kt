package com.example.shemajamebeli_8.di

import com.example.shemajamebeli_8.data.common.HandleResource
import com.example.shemajamebeli_8.data.remote.service.PlaceService
import com.example.shemajamebeli_8.data.repository.PlaceRepositoryImpl
import com.example.shemajamebeli_8.domain.repository.PlaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePlaceRepository(
        placeService: PlaceService,
        handleResource: HandleResource
    ): PlaceRepository =
        PlaceRepositoryImpl(placeService = placeService, handleResource = handleResource)
}