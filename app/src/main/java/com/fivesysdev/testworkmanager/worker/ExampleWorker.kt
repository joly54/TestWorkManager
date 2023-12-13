package com.fivesysdev.testworkmanager.worker

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.fivesysdev.testworkmanager.R
import kotlinx.coroutines.delay

class ExampleWorker(
    context: Context,
    params: WorkerParameters
): Worker(context, params) {

    override fun doWork(): Result {
        return try {
            println("Starting work...")
            doSomeWork()
            println("Work finished!")
            Result.success()
        } catch (throwable: Throwable) {
            println("Work failed!")
            Result.failure()
        }
    }
    fun doSomeWork() {
        Thread.sleep(5000)
    }
}