package com.example.shift02_FirstAApp.feature.city.list.data

import com.example.common.City
import retrofit2.http.GET

interface CitiesApi {
    @GET("/cities")
    suspend fun getAll(): List<City>
}