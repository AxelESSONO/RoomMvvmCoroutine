package com.axel.roommvvmcoroutine.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface SubscriberDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(subscriber: Subscriber) : Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAllSubscriber()

    @Query("SELECT * FROM subscriber_data_table")
    suspend fun getAllSubscriber() : LiveData<List<Subscriber>>

}