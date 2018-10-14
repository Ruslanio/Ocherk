package com.ocherk.ruslanio.ocherk.di

import android.app.Application
import com.ocherk.ruslanio.ocherk.OcherkApp
import com.ocherk.ruslanio.ocherk.di.builders.ActivityBuilder
import com.ocherk.ruslanio.ocherk.di.builders.ViewModelBuilder
import com.ocherk.ruslanio.ocherk.di.modules.app.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Ruslanio on 16.02.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        ActivityBuilder::class,
        AndroidSupportInjectionModule::class,
        ViewModelBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: OcherkApp)
}