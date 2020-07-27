package com.example.shift02_FirstAApp.presentation.UI.city.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shift02_FirstAApp.R
import com.example.shift02_FirstAApp.model.entity.City
import com.example.shift02_FirstAApp.presentation.UI.city.CityDetailActivity
import com.example.shift02_FirstAApp.presentation.viewmodel.note.list.CityListViewModel
import kotlinx.android.synthetic.main.city_list_activity.*

class CityListActivity : AppCompatActivity() {

    private val viewModelFactory = object:ViewModelProvider.Factory {
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(String::class.java).newInstance("very important string")
        }
    }
    private val viewModel:CityListViewModel by viewModels{viewModelFactory}
    private val adapter = CityListAdapter {city->
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