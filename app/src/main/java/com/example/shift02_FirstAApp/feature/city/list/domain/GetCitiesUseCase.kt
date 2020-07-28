package com.example.shift02_FirstAApp.feature.city.list.domain

import com.example.shift02_FirstAApp.feature.city.domain.entity.City

class GetCitiesUseCase(
    private val citiesRepository: CitiesRepository
) {

    operator fun invoke() : List<City> = citiesRepository.getCities()
}