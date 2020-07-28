package com.example.shift02_FirstAApp.feature.city.list.data

import com.example.shift02_FirstAApp.feature.city.domain.entity.City
import com.example.shift02_FirstAApp.feature.city.list.domain.CitiesRepository

class CityRepositoryImpl (
    private val networkCityDataSource : NetworkCityDataSource
): CitiesRepository {

    override fun getCities(): List<City> = networkCityDataSource.getCities()
}