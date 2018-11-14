package com.ocherk.ruslanio.ocherk.data.local.base

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.ocherk.ruslanio.ocherk.data.local.converters.DateConverter
import com.ocherk.ruslanio.ocherk.data.local.dao.ArticleDAO
import com.ocherk.ruslanio.ocherk.data.local.dao.NewsDAO
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList

@Database(entities = arrayOf(NewsList::class, Article::class), version = 1)
@TypeConverters(value = arrayOf(DateConverter::class))
abstract class MainDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "ocherk_database";
    }

    abstract fun newsDao() : NewsDAO

    abstract fun articleDao() : ArticleDAO
}