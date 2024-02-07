package com.example.shemajamebeli_8.data.mapper

import com.example.shemajamebeli_8.data.remote.model.PlaceDto
import com.example.shemajamebeli_8.domain.model.PlaceModel

fun PlaceDto.toDomain() =
    PlaceModel(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = reactionCount
    )