package com.ocherk.ruslanio.ocherk.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ocherk.ruslanio.ocherk.data.local.base.BaseDataObject

class Source  {
        @SerializedName("id")
        @Expose
        var sourceId: String? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
}