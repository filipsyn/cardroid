package com.filipsyn.cardroid

import android.app.Application
import android.content.Context
import com.filipsyn.cardroid.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CardroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            androidContext(this@CardroidApplication)
            modules(listOf(
                //TODO: Modules here
                databaseModule,

            ))
        }
    }


    companion object {
        lateinit var appContext: Context
            private set
    }
}