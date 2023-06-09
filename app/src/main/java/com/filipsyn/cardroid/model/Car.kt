package com.filipsyn.cardroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Car(@ColumnInfo("registration_plate") val registrationPlate: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    var id: Long? = null

    @ColumnInfo("color")
    var color: String? = null
}