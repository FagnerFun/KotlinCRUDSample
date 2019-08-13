package com.example.cinqsampleandroid


import android.util.Log
import androidx.multidex.MultiDexApplication

class CarrosApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private const val TAG = "CarrosApplication"

        // Singleton da classe Application
        private var appInstance: CarrosApplication? = null

        fun getInstance(): CarrosApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }

    }

    // Chamado quando o Android finalizar o processo do aplicativo
    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "CarrosApplication.onTerminate()")
    }
}