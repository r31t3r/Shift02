package com.example.shift02_FirstAApp.presentation.viewmodel.note.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shift02_FirstAApp.model.entity.City
import com.example.shift02_FirstAApp.presentation.viewmodel.SingleLiveEvent

class CityListViewModel  : ViewModel() {
    private val cityList = listOf (
        City("Novosibirsk", "15"),
        City("Moscow", "-15"),
        City(
            "Saint-Petersburg",
            "25"
        ),
        City("Tomsk", "35")
    )

    val cities = MutableLiveData<List<City>>()
    val cityClickedEvent = SingleLiveEvent<City>()

    init {
        cities.value = cityList
    }

    fun cityClicked(city: City) {
        cityClickedEvent(city)
    }
}