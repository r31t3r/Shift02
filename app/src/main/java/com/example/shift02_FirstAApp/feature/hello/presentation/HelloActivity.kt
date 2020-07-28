package com.example.shift02_FirstAApp.feature.hello.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shift02_FirstAApp.R
import com.example.shift02_FirstAApp.feature.city.list.presentation.CityListActivity
import kotlinx.android.synthetic.main.activity_main.*

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val intent = Intent(this, CityListActivity::class.java)
            startActivity(intent)
        }
    }
}