package com.example.pertemuan9_disasterapp

import android.os.Bundle
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
        val adapterDisaster = DisasterAdapter()

        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}