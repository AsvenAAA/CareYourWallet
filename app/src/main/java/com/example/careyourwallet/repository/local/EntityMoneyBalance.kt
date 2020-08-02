package com.example.careyourwallet.repository.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class EntityMoneyBalance (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "date") val date : LocalDate,
    @ColumnInfo(name = "income") var income : Double,
    @ColumnInfo(name = "expenses") var expenses : Double,
    @ColumnInfo(name = "balance") var balance : Double
)