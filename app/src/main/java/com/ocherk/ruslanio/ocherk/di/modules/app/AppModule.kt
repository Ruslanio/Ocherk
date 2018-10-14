package com.ocherk.ruslanio.ocherk.di.modules.app


import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.local.DBHelper
import com.ocherk.ruslanio.ocherk.data.remote.ApiHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ruslanio on 16.02.2018.
 */
@Module(includes = arrayOf(DataModule::class
        , NavigationModule::class))
class AppModule {

    @Provides
    @Singleton
    fun provideDataManager(dbHelper: DBHelper, apiHelper: ApiHelper): DataManager {
        return DataManager(dbHelper,apiHelper)
    }

}