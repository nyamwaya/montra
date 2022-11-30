package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.montra.R
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.AuthRequest
import com.app.montra.databinding.FragmentLoginBinding
import com.app.montra.presentation.onboarding.viewmodels.LoginViewModel
import com.app.montra.util.showSnackBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observables()
    }

    private fun observables() {
        viewModel.loginState.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.e(LoginFragment::class.java.simpleName, "attempting login")
                }

                is Resource.Success -> {
                    Log.e(LoginFragment::class.java.simpleName, "login success")
                    loadingState(false)
                    navigateToHome(result.data!!.user_id)
                }

                is Resource.Error -> {
                    Log.e(LoginFragment::class.java.simpleName, "login failed")
                    loadingState(false)
                    showSnackBar(
                        result.message.toString(),
                        binding.root,
                        Snackbar.LENGTH_LONG
                    )
                }
            }
        }.launchIn(lifecycleScope)
    }

    override fun onClick() {
        binding.btnLogin.btnGenericLarge.setOnClickListener {
            val isEmailEmptyOrNull = binding.emailEntryText.text.isNullOrBlank()
            val isPasswordEmptyOrNull = binding.passwordEntry.text.isNullOrBlank()

            if (isEmailEmptyOrNull) binding.errorBlankEmail.visibility = View.VISIBLE
            if (isPasswordEmptyOrNull) binding.errorBlankPassword.visibility = View.VISIBLE

            if (!isPasswordEmptyOrNull || !isPasswordEmptyOrNull) {
                binding.errorBlankPassword.visibility = View.GONE
                binding.errorBlankEmail.visibility = View.GONE

                loadingState(true)
                val email = binding.emailEntryText.text.toString()
                val password = binding.passwordEntry.text.toString()
                viewModel.login(
                    AuthRequest(
                        email = email,
                        password = password
                    )
                )
            }
        }

        binding.dontHaveAccount.setOnClickListener {
            // TODO: make sign up a link
        }

        binding.toolbar.backBtn.setOnClickListener {
            // TODO: setup back navigation
        }

        binding.forgotPassword.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment()
            findNavController().navigate(action)
        }
    }

    override fun setUpViews() {
        //TODO: add sign in with google
        binding.btnLogin.btnGenericLarge.text = resources.getString(R.string.login)
        binding.toolbar.screenLabel.setText(R.string.login)

    }

    private fun loadingState(isLoading: Boolean) {
        if (isLoading) {
            binding.mProgressbar.visibility = View.VISIBLE
            binding.btnLogin.btnGenericLarge.visibility = View.GONE
        } else {
            binding.mProgressbar.visibility = View.GONE
            binding.btnLogin.btnGenericLarge.visibility = View.VISIBLE
        }
    }

    private fun loginFormValidation() {
        //TODO: validate forms
        // TODO:make sure they aren't empty
        //  make sure passwords meets password requirements
        //  make sure email meets email requirements
    }

    private fun navigateToHome(userId: String) {
        // TODO: navigate to home activity
        // clear backstack finish parent activity
    }
}