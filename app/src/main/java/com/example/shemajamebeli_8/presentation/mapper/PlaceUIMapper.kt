package com.example.shemajamebeli_8.presentation.mapper

import com.example.shemajamebeli_8.domain.model.PlaceModel
import com.example.shemajamebeli_8.presentation.model.PlaceUI

fun PlaceModel.toPresenter(): PlaceUI =
    PlaceUI(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate
    )