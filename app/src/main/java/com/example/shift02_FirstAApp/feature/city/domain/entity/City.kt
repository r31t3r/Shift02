package com.example.shift02_FirstAApp.feature.city.domain.entity

import java.io.Serializable

data class City(
    val title: String,
    val temp: Int = 0
): Serializable