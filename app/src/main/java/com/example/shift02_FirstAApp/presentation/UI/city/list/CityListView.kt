package com.example.shift02_FirstAApp.presentation.UI.city.list

import com.example.shift02_FirstAApp.model.entity.City
import com.example.shift02_FirstAApp.presentation.UI.ViewContract

interface CityListView : ViewContract {

    fun setCityList(city: List<City>)

    fun showCityDetails(city: City)
}