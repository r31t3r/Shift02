package com.example.shift02_FirstAApp.feature.city.list.domain

import com.example.common.City

interface CitiesRepository{

    suspend fun getCities() : List<City>
}