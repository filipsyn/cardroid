package com.filipsyn.cardroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.filipsyn.cardroid.model.Car

@Database(entities = [Car::class], version = 1, exportSchema = true)
abstract class CarsDatabase : RoomDatabase() {

    abstract fun carsDao(): CarsDao

    companion object {
        private var INSTANCE: CarsDatabase? = null
        fun getDatabase(context: Context): CarsDatabase {
            if (INSTANCE == null) {
                synchronized(CarsDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            CarsDatabase::class.java, "cars_database"
                        ).fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

}