package com.ocherk.ruslanio.ocherk.data.local.dao

import android.arch.persistence.room.Dao
import com.ocherk.ruslanio.ocherk.data.local.base.BaseDao
import com.ocherk.ruslanio.ocherk.data.local.model.NewsList
import com.ocherk.ruslanio.ocherk.data.local.model.NewsModel

@Dao
abstract class NewsDAO : BaseDao<NewsList>() {
}