package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.CreateUserWithPasswordRequest
import com.app.montra.data.remote.dto.Name
import com.app.montra.data.remote.dto.UpdateUserRequest
import com.app.montra.data.remote.dto.User
import com.app.montra.databinding.FragmentSignUpBinding
import com.app.montra.presentation.onboarding.viewmodels.OnboardingViewModel
import com.app.montra.util.showSnackBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
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
        viewModel.createUserState.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.e(SignUpFragment::class.simpleName, "creating user")
                    showLoadingSpinner()
                    deactivateSignUpButton()
                }
                is Resource.Success -> {
                    Log.e(SignUpFragment::class.simpleName, "user created")
                    hideLoadingSpinner()
                    activateSignUpButton()
                }

                is Resource.Error -> {
                    Log.e(SignUpFragment::class.simpleName, "error creating user")
                    hideLoadingSpinner()
                    activateSignUpButton()
                    showSnackBar(result.message.toString(), binding.root, Snackbar.LENGTH_LONG)
                }
            }
        }.launchIn(lifecycleScope)

        viewModel.updateUserState.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.e(SignUpFragment::class.simpleName, "updating user")
                }
                is Resource.Success -> {
                    Log.e(SignUpFragment::class.simpleName, "updated user")
                    navigateToOtpScreen()
                }

                is Resource.Error -> {
                    Log.e(SignUpFragment::class.simpleName, "error updating user")
                }
            }
        }.launchIn(lifecycleScope)
    }

    override fun onClick() {
        binding.toolbar.backBtn.setOnClickListener {}

        binding.btnSignup.btnGenericLarge.setOnClickListener {
            deactivateSignUpButton()
            viewModel.createUser(
                CreateUserWithPasswordRequest(
                    email = binding.emailTextInput.text.toString(),
                    password = binding.passwordTextInput.text.toString()
                ),
                UpdateUserRequest(
                    name = Name(
                        first_name = "Alex",
                        last_name = "nyamwaya",
                        middle_name = "nyamwaya"
                    )
                )
            )
        }
    }

    override fun setUpViews() {
        binding.toolbar.screenLabel.setText(R.string.signup)
        binding.btnSignup.btnGenericLarge.setText(R.string.signup)
    }

    private fun activateSignUpButton() {
        binding.btnSignup.btnGenericLarge.isClickable = true
        binding.btnSignup.btnGenericLarge.background =
            AppCompatResources.getDrawable(
                requireActivity(),
                R.drawable.btn_large_violet
            )
        binding.btnSignup.btnGenericLarge.setBackgroundColor(
            ContextCompat.getColor(
                requireActivity(),
                R.color.violet_100
            )
        )
        binding.btnSignup.progressbar.visibility = View.GONE
        binding.btnSignup.btnGenericLarge.setText(R.string.signup)
    }

    private fun deactivateSignUpButton() {

    }

    private fun showLoadingSpinner() {

    }

    private fun hideLoadingSpinner() {

    }

    private fun navigateToOtpScreen(){
        val action = SignUpFragmentDirections.actionSignupFragmentToVerificationFragment()
        requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
    }
}