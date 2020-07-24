package com.example.shift02_FirstAApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityListAdapter : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    private val cityList: MutableList<City> = mutableListOf()
    private var cityListener: CityListener? = null

    fun setCityList(newCities: List<City>) {
        cityList.clear()
        cityList.addAll(newCities)

        notifyDataSetChanged()
    }

    fun setListener (listener: CityListener) {
        cityListener= listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        return ViewHolder(view, cityListener)
    }

    override fun getItemCount(): Int {
        return cityList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cityList[position])
    }

    class ViewHolder(itemView: View, private val cityListener: CityListener?): RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.itemTitle)

        fun bind (model: City) {
            title.text = model.title
            itemView.setOnClickListener {
                cityListener?.onClickCity(model)
            }
        }
    }

    interface CityListener{
        fun onClickCity(model: City)
    }
}