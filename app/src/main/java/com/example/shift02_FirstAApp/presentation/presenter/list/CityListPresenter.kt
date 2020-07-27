package com.example.shift02_FirstAApp.presentation.presenter.list

import com.example.shift02_FirstAApp.model.entity.City
import com.example.shift02_FirstAApp.presentation.UI.city.list.CityListView
import com.example.shift02_FirstAApp.presentation.presenter.BasePresenter

class CityListPresenter : BasePresenter<CityListView>() {

    private val cityList = listOf(
        City("Novosibirsk", "15"),
        City("Moscow", "-15"),
        City(
            "Saint-Petersburg",
            "25"
        ),
        City("Tomsk", "35")
    )

    override fun onViewAttached() {
        view?.setCityList(cityList)
    }

    fun onCityClicked(city: City) {
        view?.showCityDetails(city)
    }
}