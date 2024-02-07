package com.example.shemajamebeli_8.domain.usecase

import com.example.shemajamebeli_8.data.common.Resource
import com.example.shemajamebeli_8.domain.model.PlaceModel
import com.example.shemajamebeli_8.domain.repository.PlaceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPlaceUseCase @Inject constructor(
    private val placeRepository: PlaceRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<PlaceModel>>> = placeRepository.getAllPlace()

}