package com.example.shemajamebeli_8.domain.model

data class PlaceModel (
    val id: Int,
    val cover: String,
    val price: String,
    val title: String,
    val location: String,
    val reactionCount: Int,
    val rate: Int?
)