package com.ocherk.ruslanio.ocherk.data.local.base

import android.arch.persistence.room.PrimaryKey

abstract class BaseDataObject {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}