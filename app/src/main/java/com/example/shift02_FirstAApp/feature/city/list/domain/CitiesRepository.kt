package com.example.shift02_FirstAApp.feature.city.list.domain

import com.example.shift02_FirstAApp.feature.city.domain.entity.City

interface CitiesRepository{

    fun getCities() : List<City>
}