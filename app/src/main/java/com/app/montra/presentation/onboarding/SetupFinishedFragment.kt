package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.montra.databinding.FragmentSetupFinishedBinding

class SetupFinishedFragment : BaseFragment() {

    private var _binding: FragmentSetupFinishedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetupFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick() {
    }

    override fun setUpViews() {
    }

}