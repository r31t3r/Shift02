package com.example.shift02_FirstAApp.feature.city.list.data

import com.example.common.City


interface NetworkCityDataSource {

    suspend fun getCities(): List<City>

}

class NetworkCityDataSourceImpl(private val api: CitiesApi) : NetworkCityDataSource {

    override suspend fun getCities(): List<City> =
        api.getAll()
}