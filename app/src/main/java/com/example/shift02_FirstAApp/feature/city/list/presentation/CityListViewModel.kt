package com.example.shift02_FirstAApp.feature.city.list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.City
import com.example.shift02_FirstAApp.feature.city.list.domain.GetCitiesUseCase
import com.example.shift02_FirstAApp.feature.util.viewmodel.SingleLiveEvent
import kotlinx.coroutines.launch

class CityListViewModel(
    getCitiesUseCase: GetCitiesUseCase
): ViewModel() {

    val cities = MutableLiveData<List<City>>()
    val cityClickedEvent =
        SingleLiveEvent<City>()

    init {
        viewModelScope.launch {
            try {
                cities.value = getCitiesUseCase()
            } catch (e: Exception) {
                // show error
            }
        }
    }

    fun cityClicked(city: City) {
        cityClickedEvent(city)
    }
}