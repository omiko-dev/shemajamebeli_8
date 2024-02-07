package com.example.shemajamebeli_8.domain.usecase

import com.example.shemajamebeli_8.domain.repository.PlaceRepository
import javax.inject.Inject

class GetAllPlaceUseCase @Inject constructor(
    private val placeRepository: PlaceRepository
) {
    suspend operator fun invoke() = placeRepository.getAllPlace()
}