package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.montra.databinding.FragmentPinEntryBinding

class PinEntryFragment : BaseFragment() {
/*
* 1. detect 4 digits entered
* 2. add pin to trusted metadata
* 3. navigate to home
* */
    private lateinit var _binding: FragmentPinEntryBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPinEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick() {
    }

    override fun setUpViews() {
    }
}