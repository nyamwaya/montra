package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        onClick()
    }

    private fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.login)
        binding.btnLogin.btnGenericLarge.setText(R.string.login)
    }

    private fun onClick(){
        binding.toolbar.backBtn.setOnClickListener {
            //TODO: navigate back
        }
        binding.forgotPassword.setOnClickListener {
            val action =
                com.app.montra.onboarding.LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment()
            requireActivity().findNavController(R.id.nav_host_fragment)
                .navigate(action)
        }

    }

}