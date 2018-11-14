package com.ocherk.ruslanio.ocherk.data.local.base

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update
import com.ocherk.ruslanio.ocherk.data.local.model.Article
import io.reactivex.Completable
import io.reactivex.Single

abstract class BaseDao<in T : BaseDataObject> {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entity: T): List<Long>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract fun insert(entityList: List<T>): List<Long>

    @Update
    abstract fun update(entity: T): Int

    @Update
    abstract fun update(vararg entity: T): Int


    @Delete
    abstract fun delete(entity: T): Int

    @Delete
    abstract fun delete(vararg entity: T): Int


}