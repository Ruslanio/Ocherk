package com.ocherk.ruslanio.ocherk.data.remote

import android.arch.lifecycle.LiveData
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import com.ocherk.ruslanio.ocherk.data.remote.interfaces.GetService
import com.ocherk.ruslanio.ocherk.data.remote.interfaces.PostService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiHelper {

    companion object {
        const val BASE_URL = "https://newsapi.org/"
        const val API_KEY = "e8c8c397905144c6b6745d93757e25d6"
        const val BASE_COUNTRY = "ru"
        const val BASE_PAGE_LIMIT = 20
    }

    private var getService: GetService
    private var postService: PostService

    private val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .baseUrl(BASE_URL)
                .build()

        getService = retrofit.create(GetService::class.java)
        postService = retrofit.create(PostService::class.java)
    }

    fun getTopHeadliners(country: String = BASE_COUNTRY): Single<NewsList> {
        return getService.getTopHeadliners(API_KEY, country)
    }

    fun getEveryThing(query: String, page: Int = BASE_PAGE_LIMIT): Single<NewsList> {
        return getService.getEverything(API_KEY, query, page)
    }

}