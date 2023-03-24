package com.filipsyn.cardroid.database

import com.filipsyn.cardroid.model.Car
import kotlinx.coroutines.flow.Flow

class CarsRepositoryImpl(private val carsDao: CarsDao): ICarsRepository {
    override fun getAll(): Flow<List<Car>> {
        return carsDao.getAll()
    }

    override suspend fun insert(car: Car): Long {
        return carsDao.insert(car)
    }
}