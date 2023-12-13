package com.fivesysdev.testworkmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.fivesysdev.testworkmanager.worker.ExampleWorker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                UI()
            }
        }
    }

    @Composable
    fun UI() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Button(
                onClick = {
                    val workManager = WorkManager.getInstance(this@MainActivity)
                    workManager.enqueue(OneTimeWorkRequest.from(ExampleWorker::class.java))
                }
            ) {
                Text(text = "Start WorkManager")
            }
        }
    }
}
