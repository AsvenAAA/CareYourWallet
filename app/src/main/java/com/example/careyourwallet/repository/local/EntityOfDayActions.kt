package com.example.careyourwallet.repository.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EntityOfDayActions (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "money_action") var moneyAction : String,
    @ColumnInfo(name = "amount_of_money") var amountOfMoney : Double
)
