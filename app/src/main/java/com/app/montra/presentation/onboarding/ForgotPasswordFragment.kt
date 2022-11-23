package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : BaseFragment() {

    private lateinit var _binding: FragmentForgotPasswordBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.forgot_password)
        binding.btnContinue.btnGenericLarge.setText(R.string._continue)

    }

    override fun onClick() {
        binding.toolbar.backBtn.setOnClickListener {
            //TODO: navigate back
        }

        binding.btnContinue.btnGenericLarge.setOnClickListener {
            val action = ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToEmailSentFragment()
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
        }
    }

}