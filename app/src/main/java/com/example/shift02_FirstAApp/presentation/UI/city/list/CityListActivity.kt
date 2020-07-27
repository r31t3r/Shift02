package com.example.shift02_FirstAApp.presentation.UI.city.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shift02_FirstAApp.R
import com.example.shift02_FirstAApp.model.entity.City
import com.example.shift02_FirstAApp.presentation.UI.city.CityDetailActivity
import com.example.shift02_FirstAApp.presentation.presenter.list.CityListPresenter
import kotlinx.android.synthetic.main.city_list_activity.*

class CityListActivity : AppCompatActivity(), CityListView {

    val presenter = CityListPresenter()
    val adapter = CityListAdapter { city -> presenter.onCityClicked(city) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_list_activity)
        presenter.attachView(this)

        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
     }

    override fun setCityList(city: List<City>) {
        adapter.setCityList(city)
    }

    override fun showCityDetails(city: City) {
        val intent = Intent(this@CityListActivity, CityDetailActivity::class.java)
        intent.putExtra("City", city)
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}