package com.example.shift02_FirstAApp.feature.city.list.data

import com.example.common.City


interface NetworkCityDataSource {

    fun getCities(): List<City>

}

class NetworkCityDataSourceImpl : NetworkCityDataSource {

    override fun getCities(): List<City> = listOf(
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