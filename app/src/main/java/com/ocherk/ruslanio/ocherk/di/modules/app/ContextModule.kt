package com.ocherk.ruslanio.ocherk.di.modules.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * Created by Ruslanio on 17.02.2018.
 */
@Module
class ContextModule {

    @Provides
    @Inject
    fun provideContext(context: Application): Context {
        return context.applicationContext
    }
}