package com.example.weatherapp.adapter

import MResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R

class WeatherAdapter() : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    var mList: ArrayList<MResult> = ArrayList()

    fun setWeather(list: List<MResult>) {

            mList.clear()
            mList.addAll(list)
            notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.item_icon)
        private val title = itemView.findViewById<TextView>(R.id.weather_title)
        private val text = itemView.findViewById<TextView>(R.id.temp_text)
        fun bind(weather: MResult) {
            Glide.with(itemView.context).load("https://openweathermap.org/img/wn/${weather.weather[0].icon}.png").into(image)
//            itemView.item_icon.text = city.name
            text.text = "${weather.main.temp_max}C - ${weather.main.temp_min}C"
            title.text = "${weather.dt_txt}"

        }
    }
}