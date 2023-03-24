package com.filipsyn.cardroid.di

import com.filipsyn.cardroid.CardroidApplication
import com.filipsyn.cardroid.database.CarsDatabase
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(): CarsDatabase = CarsDatabase.getDatabase(CardroidApplication.appContext)

    single { provideDatabase()}
}