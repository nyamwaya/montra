package com.app.montra.data

//noinspection SuspiciousImport
import com.app.montra.R
import com.app.montra.R.layout.gain_control_of_your_money
import com.app.montra.R.layout.know_where_your_money_goes
import com.app.montra.R.layout.planning_ahead

enum class ModelObject(val titleResId: Int, val layoutResId: Int) {
    RED(
        R.color.purple_200,
        gain_control_of_your_money),
    BLUE(
        R.string.app_name,
        know_where_your_money_goes

    ),
    GREEN(
        R.string.signup,
        planning_ahead
    );

}