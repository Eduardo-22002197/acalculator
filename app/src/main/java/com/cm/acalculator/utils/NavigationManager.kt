package com.cm.acalculator.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.cm.acalculator.R
import com.cm.acalculator.CalculatorFragment
import com.cm.acalculator.HistoryFragment

object NavigationManager {
    private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
        val transition = fm.beginTransaction()
        transition.replace(R.id.frame, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }

    fun goToCalculatorFragment(fm: FragmentManager) {
        placeFragment(fm, CalculatorFragment())
    }

    fun goToHistoryFragment(fm: FragmentManager) {
        placeFragment(fm, HistoryFragment())
    }
}
