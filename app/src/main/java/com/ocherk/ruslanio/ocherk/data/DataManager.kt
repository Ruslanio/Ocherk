package com.ocherk.ruslanio.ocherk.data

import android.arch.lifecycle.LiveData
import com.ocherk.ruslanio.ocherk.data.local.DBHelper
import com.ocherk.ruslanio.ocherk.data.remote.ApiHelper
import com.ocherk.ruslanio.ocherk.data.remote.pojo.NewsList
import com.ocherk.ruslanio.ocherk.data.remote.util.RequestType
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.exceptions.InvalidSearchSpecException
import io.reactivex.Observable
import javax.inject.Inject

class DataManager @Inject constructor(private var dbHelper: DBHelper, private var apiHelper: ApiHelper) {
    companion object {
        const val FRESH_TIMEOUT_IN_MINUTES = 3
    }

    fun fetchNews(searchSpecification: SearchSpecification) {

    }

    fun getNewsFromWeb(searchSpecification: SearchSpecification): Observable<NewsList> {
        return when {
            searchSpecification.requestType == RequestType.TOP_HEADLINERS -> apiHelper.getTopHeadliners()
            searchSpecification.requestType == RequestType.EVERYTHING -> apiHelper.getEveryThing(searchSpecification.query)
            else -> throw InvalidSearchSpecException()
        }
    }

    fun getNewsFromDb(searchSpecification: SearchSpecification) {

    }


}