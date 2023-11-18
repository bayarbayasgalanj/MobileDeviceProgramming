package com.miu.foodiepalbayar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set up the ViewPager2 with an adapter and a callback to handle page changes
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 5 // We have 5 tabs

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> RecipesFragment()
//                    1 -> MealPlannerFragment()
//                    2 -> BlogFragment()
//                    3 -> ContactFragment()
//                    4 -> AboutMeFragment()
                    else -> RecipesFragment() // Fallback to the RecipesFragment
                }
            }
        }

        // Set the ViewPager2 to respond to tab selections
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_recipes -> viewPager.currentItem = 0
                R.id.navigation_meal_planner -> viewPager.currentItem = 1
                R.id.navigation_blog -> viewPager.currentItem = 2
                R.id.navigation_contact -> viewPager.currentItem = 3
                R.id.navigation_about_me -> viewPager.currentItem = 4
            }
            true
        }

        // Sync the ViewPager page with the selected bottom navigation item
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })
    }
}
