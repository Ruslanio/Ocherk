package com.ocherk.ruslanio.ocherk.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.ocherk.ruslanio.ocherk.data.local.base.BaseDao
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import io.reactivex.Single

@Dao
abstract class ArticleDAO : BaseDao<Article>() {

    @Query("SELECT * FROM table_article WHERE isBookmark = 1")
    abstract fun getAllBookMarks(): Single<List<Article>>

    @Query("SELECT * FROM table_article WHERE id = :articleId")
    abstract fun getArticleById(articleId: Long): Single<Article>
}
