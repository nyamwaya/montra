package com.app.montra.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.app.montra.R
import com.app.montra.databinding.FragmentAddNewAccountBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class AddNewAccountFragment : BaseFragment() {
    private var _binding: FragmentAddNewAccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick() {
    }

    override fun setUpViews() {
        setUpBottomSheet()


        binding.toolbar.screenLabel.let {
            it.setText(R.string.add_account)
            it.setTextColor(resources.getColor(R.color.light_100))
        }

        binding.toolbar.backBtn.let {
            it.setBackgroundColor(resources.getColor(R.color.violet_100))
            //set drawable icon to the white back arrow
        }
    }

    private fun setUpBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.designBottomSheet.root)

        bottomSheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, state: Int) {
                print(state)
                when (state) {

                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {

                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {

                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {

                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
    }


}