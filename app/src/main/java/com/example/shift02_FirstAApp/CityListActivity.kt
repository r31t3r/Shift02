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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_list_activity)

        val adapter = CityListAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        adapter.setCityList(cityList)
        adapter.setListener(object: CityListAdapter.CityListener {
            override fun onClickCity(model: City) {
                val intent = Intent(this@CityListActivity, CityDetailActivity::class.java)
                intent.putStringArrayListExtra("City", arrayListOf(model.title, model.temp))
                startActivity(intent)
            }
        })
    }
}