package com.example.shift02_FirstAApp.feature.city.list.domain

import com.example.common.City

class GetCitiesUseCase(
    private val citiesRepository: CitiesRepository
) {

    suspend operator fun invoke() : List<City> = citiesRepository.getCities()
}