package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.montra.R
import com.app.montra.databinding.FragmentResetPasswordBinding

class ResetPasswordFragment : BaseFragment() {

    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick() {
        binding.btnContinue.btnGenericLarge.setOnClickListener {
            //Navigate to home screen and clear backstack
        }
    }

    override fun setUpViews() {
        binding.btnContinue.btnGenericLarge.setText(R.string._continue)
    }
}