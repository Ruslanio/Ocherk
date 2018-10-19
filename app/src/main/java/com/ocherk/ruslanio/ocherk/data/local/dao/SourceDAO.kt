package com.ocherk.ruslanio.ocherk.data.local.dao

import android.arch.persistence.room.Dao
import com.ocherk.ruslanio.ocherk.data.local.base.BaseDao
import com.ocherk.ruslanio.ocherk.data.local.model.Source

@Dao
abstract class SourceDAO : BaseDao<Source>(){
}