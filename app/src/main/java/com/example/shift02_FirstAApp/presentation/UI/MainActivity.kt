package com.example.shift02_FirstAApp.presentation.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shift02_FirstAApp.R
import com.example.shift02_FirstAApp.presentation.UI.city.list.CityListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val intent = Intent(this, CityListActivity::class.java)
            startActivity(intent)
        }
    }
}