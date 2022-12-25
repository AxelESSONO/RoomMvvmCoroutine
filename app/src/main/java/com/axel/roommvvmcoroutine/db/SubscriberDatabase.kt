package com.axel.roommvvmcoroutine.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.axel.roommvvmcoroutine.utils.SUBSCRIBER_DATA_BASE

@Database(entities = [Subscriber::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDAO : SubscriberDAO

    companion object{
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null
        fun getInstance(context : Context) : SubscriberDatabase{
            var instance =  INSTANCE
            if (instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    SubscriberDatabase::class.java,
                    SUBSCRIBER_DATA_BASE
                ).build()
            }
            return instance
        }
    }
}