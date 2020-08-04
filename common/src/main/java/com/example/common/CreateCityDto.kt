package com.example.common

import java.io.Serializable

data class CreateCityDto(
    val title: String,
    val temp: Int = 0
): Serializable