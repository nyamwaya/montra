package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.databinding.FragmentSignUpBinding


class SignUpFragment : BaseFragment() {

    private lateinit var _binding: FragmentSignUpBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onClick() {
        binding.toolbar.backBtn.setOnClickListener {
            //TODO: navigate back
        }

        binding.btnOnboardingSignup.btnGenericLarge.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignupFragmentToVerificationFragment()
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
        }
    }

    override fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.signup)
        binding.btnOnboardingSignup.btnGenericLarge.setText(R.string.signup)

    }

}