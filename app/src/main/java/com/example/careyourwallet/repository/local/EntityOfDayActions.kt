package com.example.careyourwallet.repository.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "day_actions_table")
data class EntityOfDayActions (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date_time_of_action") val date_time_of_action : LocalDateTime,
    @ColumnInfo(name = "money_action") var moneyAction : String,
    @ColumnInfo(name = "amount_of_money") var amountOfMoney : Double
)
