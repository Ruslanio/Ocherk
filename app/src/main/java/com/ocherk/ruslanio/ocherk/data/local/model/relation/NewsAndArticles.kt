package com.ocherk.ruslanio.ocherk.data.local.model.relation

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import java.util.*

class NewsAndArticles {

    @Embedded
    var newsList: NewsList? = null

    @Relation(parentColumn = "id", entityColumn = "newsListId", entity = Article::class)
    var articles : List<Article> = Collections.emptyList()
}