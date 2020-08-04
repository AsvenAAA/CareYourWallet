package com.example.careyourwallet.repository.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import java.time.LocalDate

@Dao
interface Dao {
    // Для дней
    @Query("SELECT * FROM day_actions_table")
    fun getActions() : LiveData<List<EntityOfDayActions>>

    @Update
    suspend fun updateDay(entityOfDayActions: EntityOfDayActions)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToDay(entityOfDayActions: EntityOfDayActions)

    @Delete
    suspend fun deleteTargetActionInDay(entityOfDayActions: EntityOfDayActions)

    @Query("DELETE FROM day_actions_table")
    fun deleteAllActionsInDay()


    // Для месяцев
    // Не реализован способ получения данных по месяцам, иначе придется отфильтровывать в recyclerview
    @Query("SELECT * FROM balance_table")
    fun getBalance() : LiveData<List<EntityMoneyBalance>>
    // Получить данные по датам
    @Query("SELECT * FROM balance_table WHERE date LIKE :date")
    fun getBalanceMonth(date : LocalDate) :  LiveData<List<EntityMoneyBalance>>

    @Update
    suspend fun updateInBalance(entityMoneyBalance: EntityMoneyBalance)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToBalance(entityMoneyBalance: EntityMoneyBalance)

    @Query("DELETE FROM balance_table")
    fun deleteAllYearBalance()

}