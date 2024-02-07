package com.example.shemajamebeli_8.domain.repository

import com.example.shemajamebeli_8.data.common.Resource
import com.example.shemajamebeli_8.domain.model.PlaceModel
import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    suspend fun getAllPlace(): Flow<Resource<List<PlaceModel>>>
}