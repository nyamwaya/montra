package com.app.montra.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.montra.R
import com.app.montra.databinding.FragmentForgotPasswordBinding
import com.app.montra.databinding.FragmentSignUpBinding

class ForgotPasswordFragment : Fragment() {

    private lateinit var _binding: FragmentForgotPasswordBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        onClick()
    }

    private fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.forgot_password)
        binding.btnContinue.btnGenericLarge.setText(R.string._continue)

    }

    private fun onClick() {
        binding.toolbar.backBtn.setOnClickListener {
            //TODO: navigate back
        }
    }

}