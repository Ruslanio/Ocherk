package com.ocherk.ruslanio.ocherk.data.local.base

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.ocherk.ruslanio.ocherk.data.local.dao.ArticleDAO
import com.ocherk.ruslanio.ocherk.data.local.dao.NewsDAO
import com.ocherk.ruslanio.ocherk.data.local.dao.SourceDAO
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import com.ocherk.ruslanio.ocherk.data.local.model.NewsModel
import com.ocherk.ruslanio.ocherk.data.local.model.Source

@Database(entities = arrayOf(NewsList::class, Article::class, Source::class), version = 1)
abstract class MainDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "calc_database";

        fun getInstance(context: Context) = Room.databaseBuilder(context, MainDatabase::class.java, MainDatabase.DB_NAME)
                .allowMainThreadQueries() //TODO remove
                .build()
    }

    abstract fun newsDao() : NewsDAO

    abstract fun articleDao() : ArticleDAO

    abstract fun sourceDao() : SourceDAO
}