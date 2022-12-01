package com.app.montra.presentation.onboarding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.app.montra.R
import com.app.montra.databinding.ActivityOnboardingBinding
import com.app.montra.domain.models.UserModel
import com.app.montra.presentation.onboarding.viewmodels.SignUpViewModel
import com.app.montra.util.fromJson
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        removeActionBar()
        setStatusBarColor()

    }

    override fun onResume() {
        super.onResume()
        val userModel = if (viewModel.mSharedPrefs.getUserModel()
                .isNullOrEmpty()
        ) null else fromJson(viewModel.mSharedPrefs.getUserModel().toString())
        navigateToOtpPinScreen(userModel)
    }

    private fun navigateToOtpPinScreen(userModel: UserModel?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val navGraph = inflater.inflate(R.navigation.onboarding_nav_graph)
        val navController = navHostFragment.navController


        val destination = if (userModel == null) {
            //this means the user user deleted app or its first time installing
            R.id.welcome_fragment
        } else {
            // this means the user has an account but has not created a pin
            R.id.user_pin_fragment
        }

/*      TODO: enable when otp endpoint works
        else if (!userModel.isEmailVerified) {
            //if this is true we need the otp screen
            destination = R.id.otp_verification_fragment
        }*/

        navGraph.setStartDestination(destination)
        navController.graph = navGraph
    }

    private fun removeActionBar() {
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }

    private fun setStatusBarColor() {
        window.statusBarColor = ContextCompat.getColor(
            this,
            R.color.light_100
        )
    }


    private fun setNavigationGraph(userModel: UserModel) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.onboarding_nav_graph)
        // val destination = if (!userModel.isEmailVerified) R.id.welcome_fragment else R.id.otp_verification_fragment
        navGraph.setStartDestination(R.id.signup_fragment)
        navController.graph = navGraph
    }

}