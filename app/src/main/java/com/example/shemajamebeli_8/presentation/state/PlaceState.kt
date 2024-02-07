package com.example.shemajamebeli_8.presentation.state

import com.example.shemajamebeli_8.presentation.model.PlaceUI

data class PlaceState (
    val success: List<PlaceUI>? = null,
    val error: String? = null,
    val loader: Boolean = false
)