package com.filipsyn.cardroid.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.filipsyn.cardroid.model.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface CarsDao {
    @Query("SELECT * FROM cars")
    fun getAll(): Flow<List<Car>>

    @Insert
    suspend fun insert(car: Car): Long
}