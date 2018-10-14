package com.ocherk.ruslanio.ocherk.di.modules.activity

import com.ocherk.ruslanio.ocherk.di.scopes.MainScope
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class MainActivityModule {

    @MainScope
    @Provides
    fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.navigatorHolder
    }
}