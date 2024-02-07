package com.example.shemajamebeli_8.data.repository

import com.example.shemajamebeli_8.data.common.HandleResource
import com.example.shemajamebeli_8.data.common.Resource
import com.example.shemajamebeli_8.data.common.resourceMapper
import com.example.shemajamebeli_8.data.mapper.toDomain
import com.example.shemajamebeli_8.data.remote.service.PlaceService
import com.example.shemajamebeli_8.domain.model.PlaceModel
import com.example.shemajamebeli_8.domain.repository.PlaceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaceRepositoryImpl @Inject constructor(
    private val placeService: PlaceService,
    private val handleResource: HandleResource
): PlaceRepository {
    override suspend fun getAllPlace(): Flow<Resource<List<PlaceModel>>> {
        return handleResource.handleResource {
            placeService.getAllPlace()
        }.map { resource ->
            resource.resourceMapper { placeDtoList ->
                placeDtoList.map {
                    it.toDomain()
                }
            }
        }
    }
}