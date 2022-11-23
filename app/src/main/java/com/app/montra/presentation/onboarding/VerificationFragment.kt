package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.montra.R
import com.app.montra.databinding.FragmentVerificationBinding

class VerificationFragment : BaseFragment() {

    private var _binding: FragmentVerificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick() {
    }

    override fun setUpViews() {
        binding.btnVerify.btnGenericLarge.setText(R.string.verify)
        binding.toolbar.screenLabel.setText(R.string.verification)
    }

}