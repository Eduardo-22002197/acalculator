package com.cm.acalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cm.acalculator.databinding.FragmentHistoryBinding
import com.cm.acalculator.model.Calculator

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private val calculator = Calculator()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_history, container, false
        )

        binding = FragmentHistoryBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val builder = StringBuilder()
        val history = calculator.history

        history.forEach {
            builder.append("${it.expression}=${it.result}\n")
        }

        binding.tvHistory.text = builder.toString()
    }
}