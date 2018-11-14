package com.ocherk.ruslanio.ocherk.data.local

import android.arch.persistence.room.Transaction
import com.ocherk.ruslanio.ocherk.data.local.base.MainDatabase
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import com.ocherk.ruslanio.ocherk.data.local.model.Source
import com.ocherk.ruslanio.ocherk.data.local.model.relation.NewsAndArticles
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class DBHelper constructor(private var mainDatabase: MainDatabase) {

    fun addNewsList(newsList: NewsList) {

        Single.create<Long> {
            mainDatabase.runInTransaction {
                mainDatabase.newsDao().insert(newsList)
            }
        }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ id: Long? ->
                    val articles = newsList.articles
                    for (article in articles) {
                        article.newsListId = id
                    }
                    Single.create<List<Long>> { mainDatabase.articleDao().insert(*articles.toTypedArray()) }
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe()
                })
    }

    fun getLatest(): Single<NewsAndArticles> {
        return mainDatabase.newsDao().getLatest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }


    fun getAllArticles(): Single<List<Article>> {
        return mainDatabase.newsDao().getAll().map {
            val articles: List<Article> = ArrayList()
            for (newsAndArticles in it) {
                (articles as ArrayList<Article>).addAll(newsAndArticles.articles)
            }
            return@map articles
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }


    fun getLatestDate(): Single<Date> {
        return mainDatabase.newsDao().getLatestDate()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

}