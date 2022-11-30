package com.app.montra.presentation.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.app.montra.presentation.onboarding.OnboardingActivity
import com.app.montra.R

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Check to see if user Id exists in shared prefs
            // if there is no user, navigate to login page
            // if there is a user, check to see if there is pin
                //if pin, take them to home screen and finish this activity
                // if no pin, navigate to the pin fragment
        //
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
    }
}