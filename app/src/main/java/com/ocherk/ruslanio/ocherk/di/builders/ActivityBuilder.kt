package com.ocherk.ruslanio.ocherk.di.builders

import com.ocherk.ruslanio.ocherk.di.modules.activity.MainActivityModule
import com.ocherk.ruslanio.ocherk.di.scopes.MainScope
import com.ocherk.ruslanio.ocherk.ui.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @MainScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class, MainFragmentBuilder::class))
    abstract fun bindMainActivity(): MainActivity
}