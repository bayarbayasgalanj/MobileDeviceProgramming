package com.example.dbexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.dbexample.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val fragments = listOf(
            BlogFragment(),
            BlogFragment(),
        )
        val adapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
        mainBinding.viewPager.adapter = adapter

        TabLayoutMediator(mainBinding.tabLayout, mainBinding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Blog"
                1 -> "Test"
                else -> "Unknown"
            }
        }.attach()
        print("+++++++++++++++")
        setupBottomNavigationView()
    }
    private fun setupBottomNavigationView() {
        mainBinding.bottomNavigation.setOnItemSelectedListener { item ->
            mainBinding.viewPager.currentItem = when (item.itemId) {
                R.id.navigation_blog -> 0
                R.id.navigation_blog1 -> 1
                else -> 0
            }
            true
        }
    }
}
