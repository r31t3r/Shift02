package com.example.shift02_FirstAApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val intent = Intent(this, CityListActivity::class.java)
            startActivity(intent)
//            if (imageView.visibility == View.VISIBLE) {
//                imageView.visibility = View.GONE
//            } else {
//                imageView.visibility = View.VISIBLE
//            }
        }
    }
}