package com.example.shift02_FirstAApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_city.*

class CityDetailActivity: AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_city)

        val parameters = intent.getSerializableExtra("City") as City?

        titleDetail.text = parameters?.title
        tempDetail.text = parameters?.temp
    }
}