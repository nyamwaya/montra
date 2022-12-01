package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createViewPager()
        onClick()
        setUpViews()

    }

    private fun createViewPager() {
        val viewPager = binding.onboardingViewpager
        viewPager.adapter = CustomPagerAdapter(requireActivity())
        binding.indicator.setViewPager(viewPager)
    }

    private fun setUpViews(){
        binding.btnOnboardingSignup.btnGenericLarge.setText(R.string.signup)
    }

    private fun onClick() {
        binding.btnOnboardingSignup.btnGenericLarge.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnboardingFragmentToSignupFragment()
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
        }

        binding.login.setOnClickListener {
            val action = OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment()
            requireActivity().findNavController(R.id.nav_host_fragment)
                .navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}