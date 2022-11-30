package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.app.montra.R
import com.app.montra.common.Resource
import com.app.montra.data.remote.dto.AuthenticateOtpRequest
import com.app.montra.data.remote.dto.SendOtpRequest
import com.app.montra.databinding.FragmentVerificationBinding
import com.app.montra.presentation.onboarding.viewmodels.OnboardingViewModel
import com.app.montra.util.showSnackBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class VerificationFragment : BaseFragment() {

    private var _binding: FragmentVerificationBinding? = null
    private val binding get() = _binding!!

    private val viewModel by activityViewModels<OnboardingViewModel>()
    val args: VerificationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observables()
        viewModel.sendOtp(
            SendOtpRequest(
                email = args.userModel.emails[0].email
            )
        )
    }

    override fun onClick() {
        binding.btnAuthenticateOtp.btnGenericLarge.setOnClickListener {
            val otpCode = binding.pinEntryEdit.text.toString().toInt()
            viewModel.authenticateOtp(
                AuthenticateOtpRequest(
                    methodId = "",
                    otpCode = otpCode
                )
            )
        }

        binding.resendCode.setOnClickListener {
            viewModel.sendOtp(
                SendOtpRequest(
                    email = args.userModel.emails[0].email
                )
            )
        }
    }

    private fun observables() {

        viewModel.sendOtpState.onEach { result ->
            when (result) {
                is Resource.Loading -> Log.e(SignUpFragment::class.simpleName, "sending otp")

                is Resource.Success -> {
                  Log.e(SignUpFragment::class.simpleName, "otp sent")
                }
                is Resource.Error -> {
                    Log.e(SignUpFragment::class.simpleName, "error sending otp ")
                    showSnackBar(result.message.toString(), binding.root, Snackbar.LENGTH_LONG)
                }

            }
        }.launchIn(lifecycleScope)


        viewModel.authenticateOtpState.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.e(SignUpFragment::class.simpleName, "authenticating user")
                }
                is Resource.Success -> {
                    Log.e(SignUpFragment::class.simpleName, "authenticated user")
                    navigateToPinScreen()
                    //TODO save user object

                }
                is Resource.Error -> {
                    Log.e(SignUpFragment::class.simpleName, "error authenticating user")
                    showSnackBar(result.message.toString(), binding.root, Snackbar.LENGTH_LONG)
                }
            }

        }.launchIn(lifecycleScope)
    }

    override fun setUpViews() {
        binding.btnAuthenticateOtp.btnGenericLarge.setText(R.string.verify)
        binding.toolbar.screenLabel.setText(R.string.verification)
    }

    private fun navigateToPinScreen() {
        val action = VerificationFragmentDirections.actionVerificationFragmentToUserPinFragment()
        requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)

    }
}