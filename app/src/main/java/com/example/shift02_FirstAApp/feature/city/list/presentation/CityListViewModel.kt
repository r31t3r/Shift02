package com.example.shift02_FirstAApp.feature.city.list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shift02_FirstAApp.feature.city.domain.entity.City
import com.example.shift02_FirstAApp.feature.city.list.domain.GetCitiesUseCase
import com.example.shift02_FirstAApp.feature.util.viewmodel.SingleLiveEvent

class CityListViewModel(
    getCitiesUseCase: GetCitiesUseCase
): ViewModel() {

    val cities = MutableLiveData<List<City>>()
    val cityClickedEvent =
        SingleLiveEvent<City>()

    init {
        cities.value = getCitiesUseCase()
    }

    fun cityClicked(city: City) {
        cityClickedEvent(city)
    }
}