package com.ocherk.ruslanio.ocherk.di.builders

import com.ocherk.ruslanio.ocherk.di.modules.fragment.BookmarksFragmentModule
import com.ocherk.ruslanio.ocherk.di.modules.fragment.FeedFragmentModule
import com.ocherk.ruslanio.ocherk.di.modules.fragment.SettingsFragmentModule
import com.ocherk.ruslanio.ocherk.ui.view.fragment.BookmarksFragment
import com.ocherk.ruslanio.ocherk.ui.view.fragment.FeedFragment
import com.ocherk.ruslanio.ocherk.ui.view.fragment.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {

    @ContributesAndroidInjector(modules = arrayOf(FeedFragmentModule::class))
    abstract fun bindFeedFragment(): FeedFragment

    @ContributesAndroidInjector(modules = arrayOf(SettingsFragmentModule::class))
    abstract fun bindSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector(modules = arrayOf(BookmarksFragmentModule::class))
    abstract fun bindBookmarksFragment(): BookmarksFragment
}