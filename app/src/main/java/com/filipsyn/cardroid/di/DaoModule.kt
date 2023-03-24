package com.filipsyn.cardroid.di

import com.filipsyn.cardroid.database.CarsDao
import com.filipsyn.cardroid.database.CarsDatabase
import org.koin.dsl.module

val daoModule = module {
    fun provideDaoModule(database: CarsDatabase): CarsDao{
        return database.carsDao()
    }
}