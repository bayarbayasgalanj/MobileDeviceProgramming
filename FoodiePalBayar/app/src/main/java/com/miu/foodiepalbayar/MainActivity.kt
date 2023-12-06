package com.miu.foodiepalbayar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.foodiepalbayar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val fragments = listOf(
            RecipesFragment(),
            MealFragment(),
            BlogFragment(),
            ContactFragment(),
            AboutMeFragment()
        )
        val adapter = ViewPagerAdapter(fragments, supportFragmentManager, lifecycle)
        mainBinding.viewPager.adapter = adapter

        TabLayoutMediator(mainBinding.tabLayout, mainBinding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Recipes"
                1 -> "Meal Planner"
                2 -> "Blog"
                3 -> "Contact"
                4 -> "About Me"
                else -> "Unknown"
            }
        }.attach()

        setupBottomNavigationView()
        setupFloatingActionButton()
    }

    private fun setupBottomNavigationView() {
        mainBinding.bottomNavigation.setOnItemSelectedListener { item ->
            mainBinding.viewPager.currentItem = when (item.itemId) {
                R.id.navigation_recipes -> 0
                R.id.navigation_meal_planner -> 1
                R.id.navigation_blog -> 2
                R.id.navigation_contact -> 3
                R.id.navigation_about_me -> 4
                else -> 0
            }
            true
        }
    }

    private fun setupFloatingActionButton() {
        mainBinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    mainBinding.fabAddButton.show()
                    mainBinding.fabAddButton.setOnClickListener {
                        val currentFragmentTag = "f${mainBinding.viewPager.currentItem}"
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
                } else if (position == 1) {
                    mainBinding.fabAddButton.show()
                    mainBinding.fabAddButton.setOnClickListener {
                        val currentFragmentTag = "f${mainBinding.viewPager.currentItem}"
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
                } else if (position == 2) {
                    mainBinding.fabAddButton.show()
                    mainBinding.fabAddButton.setOnClickListener {
                        val currentFragmentTag = "f${mainBinding.viewPager.currentItem}"
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
                } else {
                    mainBinding.fabAddButton.hide()
                }
            }
        })
    }
}
