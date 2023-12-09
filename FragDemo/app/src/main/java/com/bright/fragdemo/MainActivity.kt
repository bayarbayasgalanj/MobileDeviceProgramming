package com.bright.fragdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bright.fragdemo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val fragments = listOf(
            FirstFragment(),
            SecondFragment()
        )
        //Write code to instantiate the ViewPagerAdapter
        val adapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
        // Write code to attach the adapter to the ViewPager2
        mainBinding.viewPager.adapter = adapter
        // Write code to attach the TabLayout to ViewPager2 using TabLayoutMediator
        TabLayoutMediator(mainBinding.tabLayout, mainBinding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "First"
                1 -> "Second"
                else -> null
            }
        }.attach()
    }
}
