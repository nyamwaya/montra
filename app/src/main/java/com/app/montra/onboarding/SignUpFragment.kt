package com.app.montra.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.montra.R
import com.app.montra.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var _binding: FragmentSignUpBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.signup)
        binding.btnOnboardingSignup.btnGenericLarge.setText(R.string.signup)
        binding.toolbar.backBtn.setOnClickListener {
            //TODO: navigate back
        }
    }

}