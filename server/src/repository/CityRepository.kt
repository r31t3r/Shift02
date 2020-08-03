package com.example.server.repository

import com.example.common.City

class CityRepository {
    fun getAll() =
        listOf(
            City(
                "Novosibirsk",
                15
            ),
            City(
                "Moscow",
                -15
            ),
            City(
                "Saint-Petersburg",
                25
            ),
            City(
                "Tomsk",
                35
            )
        )
}