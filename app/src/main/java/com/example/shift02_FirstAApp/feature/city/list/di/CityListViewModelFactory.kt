package com.example.shift02_FirstAApp.feature.city.list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shift02_FirstAApp.feature.city.list.data.CitiesApi
import com.example.shift02_FirstAApp.feature.city.list.data.CityRepositoryImpl
import com.example.shift02_FirstAApp.feature.city.list.data.NetworkCityDataSourceImpl
import com.example.shift02_FirstAApp.feature.city.list.domain.GetCitiesUseCase
import com.example.shift02_FirstAApp.feature.city.list.presentation.CityListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CityListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == CityListViewModel::class.java) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://r3-shift-back.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            val api = retrofit.create(CitiesApi::class.java)

            val networkDataSource = NetworkCityDataSourceImpl(api)
            val cityRepository = CityRepositoryImpl(networkDataSource)
            val getCityUseCase = GetCitiesUseCase(cityRepository)

            return CityListViewModel(getCityUseCase) as T
        } else {
            error("Unexpected class $modelClass")
        }
    }
}