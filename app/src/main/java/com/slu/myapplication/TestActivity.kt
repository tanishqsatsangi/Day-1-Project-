package com.slu.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TestActivity : AppCompatActivity() {

    // Dedicated tag makes lifecycle trace easy to filter in Logcat.
    private val logTag = "TestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        // onCreate() is called when this activity instance is created.
        // XML layout binding and click listener setup usually happen here.
        super.onCreate(savedInstanceState)
        Log.d(logTag, "onCreate called")

        enableEdgeToEdge()
        setContentView(R.layout.activity_test)

        // Apply system bar insets so content is not hidden under status/navigation bars.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Explicit Intent back to MainActivity.
        // This creates a visible "activity-to-activity" navigation example for lifecycle demo.
        findViewById<Button>(R.id.btnOpenMain).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        // Activity becomes visible.
        super.onStart()
        Log.d(logTag, "onStart called")
    }

    override fun onResume() {
        // Activity enters foreground and accepts user interaction.
        super.onResume()
        Log.d(logTag, "onResume called")
    }

    override fun onPause() {
        // Called when focus moves away (for example, another activity opens).
        super.onPause()
        Log.d(logTag, "onPause called")
    }

    override fun onStop() {
        // Called when this activity is fully hidden.
        super.onStop()
        Log.d(logTag, "onStop called")
    }

    override fun onRestart() {
        // Called before onStart() when returning from stopped state.
        super.onRestart()
        Log.d(logTag, "onRestart called")
    }

    override fun onDestroy() {
        // Last callback before this activity instance is removed from memory.
        super.onDestroy()
        Log.d(logTag, "onDestroy called")
    }
}