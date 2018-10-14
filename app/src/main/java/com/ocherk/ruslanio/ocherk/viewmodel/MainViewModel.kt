package com.ocherk.ruslanio.ocherk.viewmodel

import android.databinding.ObservableField
import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.remote.pojo.NewsList
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.exceptions.InvalidSearchSpecException
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(val dataManager: DataManager) : BaseViewModel() {

    var data = ObservableField<String>("")

    fun getNews() {

        var stringBuilder = StringBuilder()

        dataManager.getNewsFromWeb(SearchSpecification())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    for (article in it.articles) {
                        stringBuilder.append(article.author).append(" ")
                    }
                    data.set(stringBuilder.toString())
                }, {
                    System.out.print(it.message)
                })
    }
}