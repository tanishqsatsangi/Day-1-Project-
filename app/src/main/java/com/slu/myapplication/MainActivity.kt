package com.slu.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slu.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    // A single tag keeps lifecycle logs grouped in Logcat for this activity.
    private val logTag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        // onCreate() is called once when the activity instance is first created.
        // Use this method for one-time setup: inflate UI, initialize state, and wire listeners.
        super.onCreate(savedInstanceState)
        Log.d(logTag, "onCreate called")

        // Draw app content edge-to-edge so system bars can overlay smoothly.
        enableEdgeToEdge()

        // Compose UI tree is attached here. This is where we define what appears on screen.
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LifecycleDemoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        // Activity is becoming visible to the user.
        super.onStart()
        Log.d(logTag, "onStart called")
    }

    override fun onResume() {
        // Activity is now in foreground and user can interact with it.
        super.onResume()
        Log.d(logTag, "onResume called")
    }

    override fun onPause() {
        // Another activity is partially covering this one.
        // Good place to pause animations, camera, sensors, etc.
        super.onPause()
        Log.d(logTag, "onPause called")
    }

    override fun onStop() {
        // Activity is no longer visible.
        // Release heavier resources that are not needed in background.
        super.onStop()
        Log.d(logTag, "onStop called")
    }

    override fun onDestroy() {
        // Final callback before activity instance is destroyed.
        // This may happen due to finish() or system recreation.
        super.onDestroy()
        Log.d(logTag, "onDestroy called")
    }

    override fun onRestart() {
        // Called when returning to a stopped activity before onStart().
        super.onRestart()
        Log.d(logTag, "onRestart called")
    }
}

@Composable
fun LifecycleDemoScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MainActivity (Compose)")
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Tap button and observe lifecycle logs in Logcat.")
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Explicit Intent: source is MainActivity, destination is TestActivity.
                // This navigation lets learners observe MainActivity onPause()/onStop()
                // and TestActivity onCreate()/onStart()/onResume() sequence.
                val intent = Intent(context, TestActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Text(text = "Open TestActivity using Intent")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        LifecycleDemoScreen()
    }
}