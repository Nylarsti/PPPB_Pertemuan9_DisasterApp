package com.example.pertemuan9_disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan9_disasterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inisiasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //UI
        setContentView(binding.root)

        //inisiasi adapter
        val adapterDisaster = DisasterAdapter(generateDummy()) { disaster ->
            Toast.makeText(this@MainActivity, "You clicked on${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural"),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType =
                "Natural"),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural"),
            Disaster(nameDisaster = "Flood", disasterType = "Natural"),
            Disaster(nameDisaster = "Fire", disasterType = "Natural"),

            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made"),

            Disaster(nameDisaster = "Terrorist Attack", disasterType = "Man-made"),

            Disaster(nameDisaster = "War", disasterType = "Man-made")
        )
    }
}