package com.raju.thread.pools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doSomeMainThreadWork()
        doSomeMainThreadWork()
        doSomeLightWeightBackgroundWork()
    }

    /*
    * Using it for Background Tasks
    */
    fun doSomeBackgroundWork() {
        DefaultExecutorSupplier.getInstance().forBackgroundTasks()
            .submit(PriorityRunnable(Priority.IMMEDIATE)) {
                Log.d("raju", "doSomeBackgroundWork")
            }
    }

    /*
    * Using it for Light-Weight Background Tasks
    */
    fun doSomeLightWeightBackgroundWork() {
        DefaultExecutorSupplier.getInstance().forLightWeightBackgroundTasks()
            .execute {
                // do some light-weight background work here.
                Log.d("raju", "doSomeLightWeightBackgroundWork")
            }
    }

    /*
    * Using it for MainThread Tasks
    */
    fun doSomeMainThreadWork() {
        DefaultExecutorSupplier.getInstance().forMainThreadTasks()
            .execute {
                // do some Main Thread work here.
                Log.d("raju", "doSomeMainThreadWork")
            }
    }
}