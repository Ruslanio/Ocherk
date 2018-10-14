package com.ocherk.ruslanio.ocherk.data.local.base

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ocherk.ruslanio.ocherk.data.local.dao.NewsDAO
import com.ocherk.ruslanio.ocherk.data.local.model.NewsModel

@Database(entities = arrayOf(NewsModel::class), version = 1)
abstract class MainDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "calc_database";

        fun getInstance(context: Context) = Room.databaseBuilder(context, MainDatabase::class.java, MainDatabase.DB_NAME)
                .allowMainThreadQueries() //TODO remove
                .build()
    }

    abstract fun newsDao() : NewsDAO
}