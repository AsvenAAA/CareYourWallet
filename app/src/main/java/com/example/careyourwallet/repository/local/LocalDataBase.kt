package com.example.careyourwallet.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EntityOfDayActions::class, EntityMoneyBalance::class], version = 1, exportSchema = true)
abstract class LocalDataBase : RoomDatabase() {
    abstract val entityOfDayActions : EntityOfDayActions
    abstract val entityMoneyBalance : EntityMoneyBalance

    companion object {
        @Volatile
        private var INSTANCE_ofDayActions : EntityOfDayActions? = null
        private var INSTANCE_ofBalance : EntityMoneyBalance? = null
    }

}