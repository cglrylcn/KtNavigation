package com.caglar.ktnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.caglar.ktnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navCon: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var aaa : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navCon = navHostFrag.navController

        NavigationUI.setupActionBarWithNavController(this, navCon)

        navCon.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.firstFragment) {
                supportActionBar?.title = "$aaa. Custom Title "
                supportActionBar?.subtitle = "Subtitle: $aaa"
                aaa++
            }
            if (destination.id == R.id.secondFragment) {
                supportActionBar?.title = "$aaa. Custom Title"
                aaa++
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navCon,null)
    }
}