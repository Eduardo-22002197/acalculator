package com.cm.acalculator.model

import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {
    var display: String = "0"
        private set
    private val _history = mutableListOf<Operation>(
        Operation("1+1", "i2.0"),
        Operation("2+2", "4.0")
    )

    val history get() = _history.toList()

    fun addSymbol(symbol: String) {
        if(display == "0") display = symbol else display.plus(symbol)
    }

    fun equals() {
        val expression = ExpressionBuilder(
            display
        ).build()

        display = expression.evaluate().toString()
    }

    fun delete() {
        if(display.length > 1) display.dropLast(1) else "0"
    }

    fun clear() {
        display = "0"
    }
}