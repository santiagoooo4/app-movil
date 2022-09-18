package com.example.minticaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.minticaplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView (binding.root)
        setSupportActionBar(binding.homeToolbar)
    }

    override fun onStart() {
        super.onStart()
        val navController =  findNavController(R.id.nav_host_fragment_home)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.SpecialistFragment,
                R.id.profileFragment,
                R.id.locationFragment
            )
        )
        binding.HomeMenuNavigation.setupWithNavController(navController)
        binding.homeToolbar.setupWithNavController(navController, appBarConfiguration)
    }

}
