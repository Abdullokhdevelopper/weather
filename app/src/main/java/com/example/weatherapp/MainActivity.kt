package com.example.weatherapp

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.adapter.WeatherAdapter
import com.example.weatherapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import java.util.Date
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[WeatherViewModule::class.java]
    }
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    var postFormater: SimpleDateFormat = SimpleDateFormat("MMMM dd, yyyy HH/mm/ss")

    lateinit var weatherAdapter: WeatherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        weatherAdapter = WeatherAdapter()
        binding.mainRecycler.adapter = weatherAdapter
        binding.textView.text = postFormater.format(Calendar.getInstance().getTime())
        viewModel.weatherC.observe(this) {
            binding.textView3.text = "${it.main.temp.roundToInt()}"
            binding.textView6.text = "${it.main.humidity}"
            binding.textView7.text = "${it.main.pressure}"
//            binding.textView8.text = "${it.}"
            binding.text7.text = "${it.sys.sunrise}"
            binding.textView9.text = "${it.sys.sunset}"
//            binding.textView10.text = "${it.sys.sunset}"
            binding.textViewMaxTemp.text = "${it.main.temp_max.roundToInt()}°C"
            binding.textViewMinTemp.text = "${it.main.temp_min.roundToInt()}°C"
            //set
            Picasso.get().load("https://openweathermap.org/img/wn/${it.weather[0].icon}.png").into(binding.imageView2);
        }
        viewModel.weatherF.observe(this) {
            weatherAdapter.setWeather(it.list)
        }
        viewModel.getWeather("bishkek")
        binding.searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getWeather(query ?: "osh")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }
}

