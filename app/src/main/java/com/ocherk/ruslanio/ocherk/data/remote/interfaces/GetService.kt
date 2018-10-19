package com.ocherk.ruslanio.ocherk.data.remote.interfaces

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface GetService {

    @GET("/v2/top-headlines")
    fun getTopHeadliners(@Query("apiKey") apiKey: String, @Query("country") country: String): Single<NewsList>

    @GET("/v2/everything")
    fun getEverything(@Query("apiKey") apiKey: String,
                      @Query("q") query: String,
                      @Query("page") pageNUmber: Int): Single<NewsList>
}