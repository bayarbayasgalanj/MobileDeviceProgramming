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
}
