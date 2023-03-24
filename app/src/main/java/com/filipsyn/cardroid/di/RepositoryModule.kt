package com.filipsyn.cardroid.di

import com.filipsyn.cardroid.database.CarsDao
import com.filipsyn.cardroid.database.CarsRepositoryImpl
import com.filipsyn.cardroid.database.ICarsRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun provideCarsRepository(dao: CarsDao): ICarsRepository {
        return CarsRepositoryImpl(dao)
    }

    single { provideCarsRepository(get()) }
}