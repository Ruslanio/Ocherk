package com.ocherk.ruslanio.ocherk.data.remote.interfaces

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.ocherk.ruslanio.ocherk.data.remote.pojo.NewsList
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface GetService {

    @GET("/v2/top-headlines")
    fun getTopHeadliners(@Query("apiKey") apiKey: String, @Query("apiKey") country: String): Observable<NewsList>

    @GET("/v2/everything")
    fun getEverything(@Query("apiKey") apiKey: String,
                      @Query("q") query: String,
                      @Query("page") pageNUmber: Int): LiveData<NewsList>
}