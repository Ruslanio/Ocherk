package com.ocherk.ruslanio.ocherk.viewmodel

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor(val dataManager: DataManager) : BaseViewModel() {

    var isLoading = ObservableBoolean()
    var article = ObservableField<Article>()

    fun showDetails(articleId: Long?) {
        if (articleId != null) {
            dataManager.getArticleByIdFromDb(articleId)
                    .doOnSubscribe { isLoading.set(true) }
                    .doAfterTerminate { isLoading.set(false) }
                    .subscribe(
                            { details: Article? ->
                                article.set(details)
                            },
                            { error: Throwable? ->
                                error?.printStackTrace()
                                //TODO Exception handling
                            })
        } else {

        }
    }
}