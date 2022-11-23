package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // observables()
        onClick()
        setUpViews()
    }
    abstract fun onClick()
    abstract fun setUpViews()
    //abstract fun observables()
}