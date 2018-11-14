package com.ocherk.ruslanio.ocherk.data.local.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ocherk.ruslanio.ocherk.data.local.base.BaseDataObject

@Entity(tableName = "table_article", foreignKeys = arrayOf(
        ForeignKey(
                entity = NewsList::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("newsListId")))
)
class Article : BaseDataObject() {

    @SerializedName("source")
    @Expose
    @Embedded(prefix = "source_")
    var source: Source? = null

    @SerializedName("author")
    @Expose
    var author: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String? = null

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = null

    @SerializedName("content")
    @Expose
    var content: String? = null

    var newsListId: Long? = null

}