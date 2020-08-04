package com.example.shift02_FirstAApp.feature.city.list.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.City
import com.example.shift02_FirstAApp.R
import com.example.shift02_FirstAApp.feature.city.detail.presentation.CityDetailActivity
import com.example.shift02_FirstAApp.feature.city.list.di.CityListViewModelFactory
import kotlinx.android.synthetic.main.city_list_activity.*

class CityListActivity : AppCompatActivity() {


    private val viewModel: CityListViewModel by viewModels{
        CityListViewModelFactory()
    }
    private val adapter =
        CityListAdapter { city ->
            viewModel.cityClicked(city)
        }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.city_list_activity)
            viewModel.cities.observe(this, Observer (::setCityList))
            viewModel.cityClickedEvent.observe(this, Observer (::showCityDetails))

            val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager

        }

        private fun setCityList(citiesList: List<City>) {
            adapter.setCityList(citiesList)
        }

        private fun showCityDetails(city: City) {
            val intent = Intent(this@CityListActivity, CityDetailActivity::class.java)
            intent.putExtra("City", city)
            startActivity(intent)
        }
}