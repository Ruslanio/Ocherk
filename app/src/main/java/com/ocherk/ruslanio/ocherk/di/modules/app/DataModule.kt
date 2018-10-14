package com.ocherk.ruslanio.ocherk.di.modules.app

import android.arch.persistence.room.Room
import android.content.Context
import com.ocherk.ruslanio.ocherk.data.local.DBHelper
import com.ocherk.ruslanio.ocherk.data.local.base.MainDatabase
import com.ocherk.ruslanio.ocherk.data.remote.ApiHelper

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ruslanio on 17.02.2018.
 */
@Singleton
@Module(includes = arrayOf(ContextModule::class))
class DataModule {

    @Singleton
    @Provides
    fun provideDBHelper(context: Context): DBHelper {
        val mainDatabase = Room.databaseBuilder(context, MainDatabase::class.java, MainDatabase.DB_NAME)
                .allowMainThreadQueries() //TODO remove
                .build()
        return DBHelper(mainDatabase)
    }

    @Singleton
    @Provides
    fun provideApiHelper(): ApiHelper {
        return ApiHelper()
    }

}