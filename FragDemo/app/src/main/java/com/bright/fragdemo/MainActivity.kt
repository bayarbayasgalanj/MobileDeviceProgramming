package com.bright.fragdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bright.fragdemo.data.Plant
import com.bright.fragdemo.data.PlantRepository
import com.bright.fragdemo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        // Initialize and set up ViewPager and TabLayout
        setupViewPagerAndTabs()
        // Insert sample data
        insertSamplePlants()
    }

    private fun setupViewPagerAndTabs() {
        val fragments = listOf(FirstFragment(), SecondFragment())
        val adapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
        mainBinding.viewPager.adapter = adapter
        TabLayoutMediator(mainBinding.tabLayout, mainBinding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "First"
                1 -> "Second"
                else -> null
            }
        }.attach()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun insertSamplePlants() {
        val plantRepository = PlantRepository(application)
        lifecycleScope.launch(Dispatchers.IO) {
            val samplePlants = listOf(
                Plant(name = "name1", type = "Type1"),
                Plant(name = "name2", type = "Type2"),
                Plant(name = "name3", type = "Type3")
            )
            // Add logic to check if insert is necessary
//            if (plantRepository.isDatabaseEmpty()) {
                samplePlants.forEach { plant ->
                    plantRepository.insert(plant)
                }
//            }
        }
    }
}
