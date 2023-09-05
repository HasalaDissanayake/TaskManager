package com.example.taskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // import image
        val splashScreenImg = findViewById<ImageView>(R.id.splashScreenImg)

        // to make the Splash image invisible
        splashScreenImg.alpha = 0f
        // Image will be visible gradually
        splashScreenImg.animate().setDuration(3000).alpha(1f).withEndAction {
            val i = Intent(this, TaskListActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}