package com.app.montra.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.montra.databinding.FragmentPinEntryBinding

class PinEntryFragment : BaseFragment() {

    private lateinit var _binding: FragmentPinEntryBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPinEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick() {
    }

    override fun setUpViews() {
    }
}