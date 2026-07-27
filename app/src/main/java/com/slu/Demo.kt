package com.slu.myapplication

class Demo {
    // Simple function used to explain Kotlin's `when` expression.
    // We choose one branch based on the current value of `a`.
    fun demoFunction() {
        // Local immutable variable (`val`) cannot be reassigned later.
        val a = 5

        // `when` works like switch-case and is more flexible in Kotlin.
        when (a) {
            1 -> println("One")
            2 -> println("Two")
            // Default branch runs when none of the above conditions match.
            else -> println("Value is not 1 or 2")
        }
    }
}