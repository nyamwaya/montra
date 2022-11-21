package com.app.montra.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.montra.R
import com.app.montra.databinding.FragmentOnboardingBinding
import com.app.montra.databinding.FragmentSetUpAccountBinding

class SetUpAccountFragment : BaseFragment() {

    private var _binding: FragmentSetUpAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetUpAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick() {
        binding.btnLetsGo.btnGenericLarge.setOnClickListener {

        }
    }

    override fun setUpViews() {
        binding.btnLetsGo.btnGenericLarge.setText(R.string.lets_go)
    }

}