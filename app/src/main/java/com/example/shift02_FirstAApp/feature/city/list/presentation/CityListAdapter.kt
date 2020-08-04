package com.example.shift02_FirstAApp.feature.city.list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.City
import com.example.shift02_FirstAApp.R

class CityListAdapter(private val clickListener:(City) -> Unit) : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    private val cityList: MutableList<City> = mutableListOf()

    fun setCityList(newCities: List<City>) {
        cityList.clear()
        cityList.addAll(newCities)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        return ViewHolder(
            view,
            clickListener
        )
    }

    override fun getItemCount(): Int {
        return cityList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cityList[position])
    }

    class ViewHolder(itemView: View, private val cityListener: (City) -> Unit): RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.itemTitle)

        fun bind (model: City) {
            title.text = model.title
            itemView.setOnClickListener {
                cityListener(model)
            }
        }
    }
}