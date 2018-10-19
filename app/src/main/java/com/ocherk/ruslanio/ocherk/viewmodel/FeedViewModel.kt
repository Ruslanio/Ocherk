package com.ocherk.ruslanio.ocherk.viewmodel

import android.databinding.ObservableField
import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import com.ocherk.ruslanio.ocherk.ui.adapters.NewsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FeedViewModel @Inject constructor(val dataManager: DataManager) : BaseViewModel() {
    val adapter = NewsAdapter()

    val isLoading = ObservableField<Boolean>()

    fun getNews() {

        dataManager.getNewsFromWeb(SearchSpecification())
                .doOnSubscribe { isLoading.set(true) }
                .doAfterTerminate { isLoading.set(false) }
                .subscribe({
                    adapter.articles = it.articles
                }, {
                    System.out.print(it.message)
                })
    }

}