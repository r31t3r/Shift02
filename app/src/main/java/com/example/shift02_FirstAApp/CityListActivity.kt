package com.example.shift02_FirstAApp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.city_list_activity.*

class CityListActivity : AppCompatActivity() {
    private val cityList = listOf (
        City ("Novosibirsk", "15"),
        City ("Moscow", "-15"),
        City ("Saint-Petersburg", "25"),
        City ("Tomsk", "35")
    )

    val adapter = CityListAdapter {city ->
        val intent = Intent(this@CityListActivity, CityDetailActivity::class.java)
        intent.putExtra("City", city)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_list_activity)

        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setCityList(cityList)
     }
}