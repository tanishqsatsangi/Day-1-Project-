package com.slu.myapplication

// Base class with common student properties and grade logic.
open class Student {
    // Sample properties used for demonstration.
    val name = "Xyz"
    val marks = 50

    // Calculates grade text based on total marks.
    fun score(totalMarks: Int): String {
        var score: String = "Invalid marks"
        when (totalMarks) {
            in 40 until 49 -> score = "Fail"
            in 50..60 -> score = "Pass"
            in 60..70 -> score = "Good"
            in 70..80 -> score = "Very Good"
            in 80..90 -> score = "Excellent"
            in 90..100 -> score = "Outstanding"
            else -> score = "Invalid marks"
        }
        return score
    }
}

// Derived class that reuses Student properties and behavior.
class Total : Student() {
    val standard: String = "Fifth"
    val attendance: Int? = 80

    // Adds bonus marks if attendance is above 75%.
    // Safe-call + let handles nullable attendance cleanly.
    fun totalMarks(): Int = attendance?.let {
        if (it > 75) marks + 5 else marks
    } ?: 0

    // Prints all final details to the console.
    fun printAllDetails() {
        val score = score(totalMarks = totalMarks())
        println("Name: $name")
        println("Score: $score")
        println("Standard: $standard")
    }


}

// Singleton object: one shared instance in the app.
object ABC {
    val value = 5
}

fun main() {
    // Nullable example (`String?`) to explain Kotlin null-safety.
    val s: String? = null
    println(s)
    println(ABC.value)
}
