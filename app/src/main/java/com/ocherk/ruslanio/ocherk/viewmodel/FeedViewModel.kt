package com.ocherk.ruslanio.ocherk.viewmodel

import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import com.ocherk.ruslanio.ocherk.ui.adapters.NewsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FeedViewModel @Inject constructor(val dataManager: DataManager) : BaseViewModel(){
    val adapter = NewsAdapter()

    fun getNews() {

        dataManager.getNewsFromWeb(SearchSpecification())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.articles = it.articles
                }, {
                    System.out.print(it.message)
                })
    }

}