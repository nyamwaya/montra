package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.databinding.FragmentSignUpBinding
import com.auth0.android.Auth0


class SignUpFragment : BaseFragment() {

    private lateinit var _binding: FragmentSignUpBinding
    private val binding get() = _binding
    private lateinit var account: Auth0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set up the account object with the Auth0 application details
        account = Auth0(
            getString(R.string.auth0_client_id),
            getString(R.string.auth0_domain)
        )
    }
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
            val action =
                com.app.montra.onboarding.SignUpFragmentDirections.actionSignupFragmentToVerificationFragment()
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
        }
    }

    override fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.signup)
        binding.btnOnboardingSignup.btnGenericLarge.setText(R.string.signup)

    }

}