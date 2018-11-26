package com.ocherk.ruslanio.ocherk.data

import android.arch.persistence.room.EmptyResultSetException
import com.ocherk.ruslanio.ocherk.data.local.DBHelper
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import com.ocherk.ruslanio.ocherk.data.local.model.relation.NewsAndArticles
import com.ocherk.ruslanio.ocherk.data.remote.ApiHelper
import com.ocherk.ruslanio.ocherk.data.remote.util.RequestType
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.exceptions.InvalidSearchSpecException
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class DataManager @Inject constructor(private var dbHelper: DBHelper, private var apiHelper: ApiHelper) {
    companion object {
        const val FRESH_TIMEOUT_IN_MINUTES = 3
    }

    fun fetchNews(searchSpecification: SearchSpecification = SearchSpecification(), isForceUpdate: Boolean): Single<List<Article>> {

        return Single.create<List<Article>> {

            dbHelper.getLatestDate().subscribe({ date: Date? ->
                if (!isForceUpdate && isFresh(date)) {
                    dbHelper.getLatest().map { t: NewsAndArticles ->
                        return@map t.articles
                    }.subscribe { articles: List<Article>? ->
                        it.onSuccess(articles ?: Collections.emptyList())
                    }
                } else {
                    getNewsFromWeb(searchSpecification)
                            .subscribe { newsList: NewsList? ->
                                if (newsList != null) {
                                    cacheData(newsList)
                                    it.onSuccess(newsList.articles)
                                } else {
                                    it.onSuccess(Collections.emptyList())
                                }
                            }
                }
            }, { error: Throwable? ->
                if (error is EmptyResultSetException) {
                    getNewsFromWeb(searchSpecification)
                            .subscribe { newsList: NewsList? ->
                                if (newsList != null) {
                                    cacheData(newsList)
                                    it.onSuccess(newsList.articles)
                                } else {
                                    it.onSuccess(Collections.emptyList())
                                }
                            }
                } else {
                    error?.printStackTrace()
                }
            })

        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getNewsFromWeb(searchSpecification: SearchSpecification): Single<NewsList> {
        return when {
            searchSpecification.requestType == RequestType.TOP_HEADLINERS -> apiHelper.getTopHeadliners()
            searchSpecification.requestType == RequestType.EVERYTHING -> apiHelper.getEveryThing(searchSpecification.query)
            else -> throw InvalidSearchSpecException()
        }.observeOn(AndroidSchedulers.mainThread())

    }

    private fun getNewsFromDb(searchSpecification: SearchSpecification): Single<List<Article>> {
        return dbHelper.getAllArticles()
    }

    private fun cacheData(data: NewsList) {
        data.date = Calendar.getInstance().time
        dbHelper.addNewsList(data)
    }

    private fun isFresh(date: Date?): Boolean {
        return false //TODO is there fresh articles in DB check
    }

    fun getBookmarks(): Single<List<Article>> {
        return dbHelper.getBookmarks()
    }

}
