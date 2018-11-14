package com.ocherk.ruslanio.ocherk.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.ocherk.ruslanio.ocherk.data.local.base.BaseDao
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import com.ocherk.ruslanio.ocherk.data.local.model.relation.NewsAndArticles
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

@Dao
abstract class NewsDAO : BaseDao<NewsList>() {

    @Transaction
    @Query("SELECT * FROM table_news")
    abstract fun getAll(): Single<List<NewsAndArticles>>


    @Transaction
    @Query("SELECT *, MAX(date) FROM table_news")
    abstract fun getLatest() : Single<NewsAndArticles>


    @Query("SELECT MAX(date) FROM table_news")
    abstract fun getLatestDate() : Single<Date>
}