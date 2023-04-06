package com.cm.acalculator

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cm.acalculator.databinding.FragmentCalculatorBinding
import com.cm.acalculator.model.Calculator

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private val calculator = Calculator()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_calculator, container, false
        )

        binding = FragmentCalculatorBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.button0.setOnClickListener { onClickSymbol("0") }
        binding.button1.setOnClickListener { onClickSymbol("1") }
        binding.button2.setOnClickListener { onClickSymbol("2") }
        binding.button3.setOnClickListener { onClickSymbol("3") }
        binding.button4.setOnClickListener { onClickSymbol("4") }
        binding.button5.setOnClickListener { onClickSymbol("5") }
        binding.button6.setOnClickListener { onClickSymbol("6") }
        binding.button7.setOnClickListener { onClickSymbol("7") }
        binding.button8.setOnClickListener { onClickSymbol("8") }
        binding.button9.setOnClickListener { onClickSymbol("9") }
        binding.buttonAdition.setOnClickListener { onClickSymbol("+") }
        binding.buttonSubtraction.setOnClickListener { onClickSymbol("-") }
        binding.buttonMultiplication.setOnClickListener { onClickSymbol("*") }
        binding.buttonDivision.setOnClickListener { onClickSymbol("/") }
        binding.buttonDot.setOnClickListener { onClickSymbol(".") }
        binding.buttonEquals.setOnClickListener { onClickEquals() }
        binding.buttonClear.setOnClickListener { onClear() }
        binding.buttonBackspace.setOnClickListener { onDelete() }
    }

    private fun onClickSymbol(symbol: String) {
        logClickOnButton(symbol)
        calculator.addSymbol(symbol)
        binding.textVisor.text = calculator.display
    }

    private fun onClickEquals() {
        logClickOnButton("=")
        calculator.equals()
        binding.textVisor.text = calculator.display
        Log.i(TAG, "Expression result: ${binding.textVisor.text}")
    }

    private fun onDelete() {
        logClickOnButton("<")
        calculator.delete()
        binding.textVisor.text = calculator.display
    }

    private fun onClear() {
        logClickOnButton("CE")
        calculator.clear()
        binding.textVisor.text = calculator.display
    }

    private fun logClickOnButton(button: String) {
        Log.i(TAG, "Clicked on button: $button")
    }
}