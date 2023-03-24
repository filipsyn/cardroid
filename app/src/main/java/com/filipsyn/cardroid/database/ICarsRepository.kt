package com.filipsyn.cardroid.database

import com.filipsyn.cardroid.model.Car
import kotlinx.coroutines.flow.Flow

interface ICarsRepository {
    fun getAll(): Flow<List<Car>>
    suspend fun insert(car: Car): Long
}