package com.cm.acalculator.model

import net.objecthunter.exp4j.ExpressionBuilder

object Calculator {
    var display: String = "0"
        private set
    private val _history = mutableListOf<Operation>(
        Operation("1+1", "2.0"),
        Operation("2+2", "4.0")
    )

    val history get() = _history.toList()

    fun addSymbol(symbol: String) {
        if(display == "0") display = symbol else display = "$display$symbol"
    }

    fun equals() {
        val expression = ExpressionBuilder(display).build()
        val result = expression.evaluate().toString()

        _history.add(Operation(display, result))
        display = result
    }

    fun delete() {
        if (display.isNotEmpty() && display.length > 1) {
            val newDisp = display.dropLast(1)
            display = newDisp

        } else {
            display = "0"
        }
    }

    fun clear() {
        display = "0"
    }
}