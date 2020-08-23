package com.example.careyourwallet.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityOfDayActions::class, EntityMoneyBalance::class], version = 1, exportSchema = true)
abstract class LocalRoomDataBase : RoomDatabase() {
    abstract val entityOfDayActions : EntityOfDayActions
    abstract val entityMoneyBalance : EntityMoneyBalance

    companion object {
        // Аннотация @Volatile запрещает кешировать данные, вся информация будет
        // записываться напрямую в память устройства и читаться из нее же
        // Она предотвращает ситуации когда одновременно несколько запросов меняют одну и ту же ячейку однвеменно
        @Volatile
        private var INSTANCE : LocalRoomDataBase? = null

        fun getInstance(context : Context) : LocalRoomDataBase {
            // Функция synchronized нужна для того, чтобы единовременно к базе
            // мог обратиться только один поток в момент создания базы, т.е. предотвращается ситуация,
            // когда в одно время несколько потоков пытаются создать базу, в итоге их получается две, вместо одной
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                    LocalRoomDataBase::class.java,
                    "day_actions_database")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}


