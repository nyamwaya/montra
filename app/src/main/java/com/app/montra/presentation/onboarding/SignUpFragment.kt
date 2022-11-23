package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.databinding.FragmentSignUpBinding
import com.app.montra.util.requestBodyToJson
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch


class SignUpFragment : BaseFragment() {

    private lateinit var _binding: FragmentSignUpBinding
    private val binding get() = _binding

    private val viewModel by viewModels<OnboardingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observables()
    }

    private fun observables() {
        lifecycleScope.launch {
            viewModel.createUserState.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        Log.e(SignUpFragment::class.simpleName, "creating user")
                        binding.btnSignup.btnGenericLarge.isClickable = false
                        binding.btnSignup.btnGenericLarge.background =
                            AppCompatResources.getDrawable(
                                requireActivity(),
                                R.drawable.btn_large_unactive
                            )
                        binding.btnSignup.btnGenericLarge.text = "Loading.."
                        binding.btnSignup.progressbar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        Log.e(
                            SignUpFragment::class.simpleName,
                            "user created successfully" + result.data?.user?.emails
                        )
                        binding.btnSignup.btnGenericLarge.isClickable = true
                        binding.btnSignup.btnGenericLarge.background =
                            AppCompatResources.getDrawable(
                                requireActivity(),
                                R.drawable.btn_large_purple
                            )
                        binding.btnSignup.progressbar.visibility = View.GONE
                        binding.toolbar.screenLabel.setText(R.string.signup)

                        val action =
                            SignUpFragmentDirections.actionSignupFragmentToVerificationFragment()
                        requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
                    }
                    is Resource.Error -> {
                        Log.e(
                            SignUpFragment::class.simpleName,
                            "error creating user" + result.message
                        )
                        binding.btnSignup.btnGenericLarge.isClickable = true
                        binding.btnSignup.btnGenericLarge.background =
                            AppCompatResources.getDrawable(
                                requireActivity(),
                                R.drawable.btn_large_purple
                            )
                        binding.btnSignup.progressbar.visibility = View.GONE
                        binding.toolbar.screenLabel.setText(R.string.signup)

                        Snackbar.make(
                            binding.root,
                            result.message.toString(),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    override fun onClick() {
        binding.toolbar.backBtn.setOnClickListener {}

        binding.btnSignup.btnGenericLarge.setOnClickListener {
            viewModel.createUserWithPassword(
                requestBodyToJson(
                    CreateUserWithPasswordRequest(
                        email = binding.emailTextInput.text.toString(),
                        password = binding.emailTextInput.text.toString()
                    )
                )
            )
        }
    }

    override fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.signup)
        binding.btnSignup.btnGenericLarge.setText(R.string.signup)
    }
}