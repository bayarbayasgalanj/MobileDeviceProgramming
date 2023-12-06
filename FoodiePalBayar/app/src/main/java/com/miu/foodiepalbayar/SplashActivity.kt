package com.miu.foodiepalbayar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val spinAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        val foodAnimationImageView = findViewById<ImageView>(R.id.food_animation)
        foodAnimationImageView.startAnimation(spinAnimation)

        // Use a Handler to delay the transition to the main activity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close the splash activity to prevent going back to it
        }, SPLASH_DELAY)
    }
}