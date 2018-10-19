package com.ocherk.ruslanio.ocherk.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ocherk.ruslanio.ocherk.data.local.base.BaseDataObject
import java.util.*

@Entity(tableName = "table_news")
class NewsList constructor() : BaseDataObject() {

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null

    @SerializedName("articles")
    @Expose
    @Ignore
    var articles: List<Article> = Collections.emptyList()

}