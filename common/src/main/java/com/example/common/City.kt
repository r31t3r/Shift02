package com.example.common

import java.io.Serializable

data class City(
    val id: Long,
    val title: String,
    val temp: Int = 0
): Serializable