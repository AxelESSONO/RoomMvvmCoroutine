package com.axel.roommvvmcoroutine.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.axel.roommvvmcoroutine.utils.*

@Entity(tableName = TABLE_NAME)
data class Subscriber(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = SUBSCRIBER_ID)
    val id : Int,

    @ColumnInfo(name = SUBSCRIBER_NAME)
    val name : String,

    @ColumnInfo(name = SUBSCRIBER_EMAIL)
    val email : String
)
