package com.example.pertemuan9_disasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
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
            Toast.makeText(this@MainActivity, "You clicked on ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }

        with(binding){
            //linearlayoutmanager
            //    rvDisaster.apply {
            //        adapter = adapterDisaster
            //        layoutManager = LinearLayoutManager(this@MainActivity)
            //    }
            //gridlayoutmanager
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural", imageDisaster = R.drawable.tsunami),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType = "Natural", imageDisaster = R.drawable.volcanic_eruption),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural", imageDisaster = R.drawable.earthquake),
            Disaster(nameDisaster = "Flood", disasterType = "Natural", imageDisaster = R.drawable.flood),
            Disaster(nameDisaster = "Fire", disasterType = "Natural", imageDisaster = R.drawable.fire),
            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made", imageDisaster = R.drawable.nuclear_accident),
            Disaster(nameDisaster = "Terrorist Attack", disasterType = "Man-made", imageDisaster = R.drawable.terrorist_attack),
            Disaster(nameDisaster = "War", disasterType = "Man-made", imageDisaster = R.drawable.war)
        )
    }
}