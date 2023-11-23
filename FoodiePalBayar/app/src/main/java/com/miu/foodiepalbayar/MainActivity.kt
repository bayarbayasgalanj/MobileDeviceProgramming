// MainActivity.kt

package com.miu.foodiepalbayar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fabAddButton: FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        fabAddButton = findViewById(R.id.fab_add_button) // Assign FAB from the layout

        // Set up the ViewPager2 with an adapter and a callback to handle page changes
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 5 // We have 5 tabs

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> RecipesFragment()
                    1 -> MealFragment()
                    2 -> BlogFragment()
                    3 -> ContactFragment()
                    4 -> AboutMeFragment()
                    else -> RecipesFragment() // Fallback to the RecipesFragment
                }
            }
        }

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

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
                if (position == 0) {
                    fabAddButton.show()
                    fabAddButton.setOnClickListener {
                        val currentFragmentTag = "f${viewPager.currentItem}"
                        val currentFragment = supportFragmentManager.findFragmentByTag(currentFragmentTag)

                        if (currentFragment is RecipesFragment) {
                            val addRecipeDialog = AddDialogFragment.newInstance(R.layout.dialog_add_recipe)
                            addRecipeDialog.listener = object : AddDialogFragment.AddRecipeListener {
                                override fun onRecipeAdded(recipe: Recipe) {
                                    currentFragment.onRecipeAdded(recipe)
                                }
                            }
                            addRecipeDialog.show(supportFragmentManager, "addRecipe")
                        }
                    }
                }
                else if (position == 1) {
                    fabAddButton.show()
                    fabAddButton.setOnClickListener {
                        val currentFragmentTag = "f${viewPager.currentItem}"
                        val currentFragment = supportFragmentManager.findFragmentByTag(currentFragmentTag)
                        if (currentFragment is MealFragment) {
                            val addMealDialog = AddDialogFragment.newInstance(R.layout.dialog_add_meal)
                            addMealDialog.listenerMeal = object : AddDialogFragment.AddMealListener {
                                override fun onMealAdded(meal: Meal) {
                                    currentFragment.onMealAdded(meal)
                                }
                            }
                            addMealDialog.show(supportFragmentManager, "addMeal")
                        }
                    }
                }
                else if (position == 2) {
                    fabAddButton.show()
                    fabAddButton.setOnClickListener {
                        val currentFragmentTag = "f${viewPager.currentItem}"
                        val currentFragment = supportFragmentManager.findFragmentByTag(currentFragmentTag)
                        if (currentFragment is BlogFragment) {
                            val addBlogDialog = AddDialogFragment.newInstance(R.layout.dialog_add_blog)
                            addBlogDialog.listenerBlog = object : AddDialogFragment.AddBlogListener {
                                override fun onBlogAdded(blog: Blog) {
                                    currentFragment.onBlogAdded(blog)
                                }
                            }
                            addBlogDialog.show(supportFragmentManager, "addBlog")
                        }
                    }
                }
                else {
                    fabAddButton.hide() // Hide the button for other pages
                }
            }
        })
    }
}
