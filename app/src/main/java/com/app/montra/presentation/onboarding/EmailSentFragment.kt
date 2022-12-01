package com.app.montra.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.app.montra.R
import com.app.montra.databinding.FragmentEmailSentBinding

class EmailSentFragment : BaseFragment() {

    private lateinit var _binding: FragmentEmailSentBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailSentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        setUpViews()
    }

    override fun setUpViews() {
        binding.btnBackToEmail.btnGenericLarge.setText(R.string.back_to_login)
    }

    override fun onClick() {
        binding.btnBackToEmail.btnGenericLarge.setOnClickListener {
            val action = EmailSentFragmentDirections.actionEmailSentFragmentToLoginFragment()
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
        }
    }

}