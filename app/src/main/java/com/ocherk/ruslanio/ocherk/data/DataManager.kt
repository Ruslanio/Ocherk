package com.ocherk.ruslanio.ocherk.data

import android.arch.lifecycle.LiveData
import com.ocherk.ruslanio.ocherk.data.local.DBHelper
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import com.ocherk.ruslanio.ocherk.data.remote.ApiHelper
import com.ocherk.ruslanio.ocherk.data.remote.util.RequestType
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.exceptions.InvalidSearchSpecException
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class DataManager @Inject constructor(private var dbHelper: DBHelper, private var apiHelper: ApiHelper) {
    companion object {
        const val FRESH_TIMEOUT_IN_MINUTES = 3
    }

    fun fetchNews(searchSpecification: SearchSpecification) {

    }

    fun getNewsFromWeb(searchSpecification: SearchSpecification): Single<NewsList> {
        return when {
            searchSpecification.requestType == RequestType.TOP_HEADLINERS -> apiHelper.getTopHeadliners()
            searchSpecification.requestType == RequestType.EVERYTHING -> apiHelper.getEveryThing(searchSpecification.query)
            else -> throw InvalidSearchSpecException()
        }.observeOn(AndroidSchedulers.mainThread())

    }

    fun getNewsFromDb(searchSpecification: SearchSpecification) {

    }

    fun cacheData(data: NewsList){

    }

}