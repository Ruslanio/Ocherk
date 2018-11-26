package com.ocherk.ruslanio.ocherk.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import com.ocherk.ruslanio.ocherk.navigation.ScreenNames
import com.ocherk.ruslanio.ocherk.ui.adapters.NewsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class FeedViewModel @Inject constructor(val router: Router, val dataManager: DataManager) : BaseViewModel() {
    val adapter = NewsAdapter()

    val isLoading = ObservableBoolean()

    val refreshListener = SwipeRefreshLayout.OnRefreshListener {
        getNews(true)
    }

    init {
        adapter.onItemClickListener = View.OnClickListener {
            router.navigateTo(ScreenNames.DetailsScreen())
        }
    }

    fun getNews(forceUpdate: Boolean) {
        dataManager.fetchNews(SearchSpecification(), forceUpdate)
                .doOnSubscribe { isLoading.set(true) }
                .doAfterTerminate { isLoading.set(false) }
                .subscribe({
                    adapter.articles = it
                }, {
                    System.out.print(it.message)
                })
    }

}