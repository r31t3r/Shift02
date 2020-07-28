package com.example.shift02_FirstAApp.feature.city.list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shift02_FirstAApp.feature.city.list.data.CityRepositoryImpl
import com.example.shift02_FirstAApp.feature.city.list.data.NetworkCityDataSource
import com.example.shift02_FirstAApp.feature.city.list.data.NetworkCityDataSourceImpl
import com.example.shift02_FirstAApp.feature.city.list.domain.GetCitiesUseCase
import com.example.shift02_FirstAApp.feature.city.list.presentation.CityListViewModel

class CityListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == CityListViewModel::class.java) {
            val networkDataSource = NetworkCityDataSourceImpl()
            val cityRepository = CityRepositoryImpl(networkDataSource)
            val getCityUseCase = GetCitiesUseCase(cityRepository)

            return CityListViewModel(getCityUseCase) as T
        } else {
            error("Unexpected class $modelClass")
        }
    }
}