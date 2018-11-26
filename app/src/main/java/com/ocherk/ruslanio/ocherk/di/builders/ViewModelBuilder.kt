package com.ocherk.ruslanio.ocherk.di.builders

import android.arch.lifecycle.ViewModelProvider
import com.ocherk.ruslanio.ocherk.di.ViewModelKey
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModelFactory
import com.ocherk.ruslanio.ocherk.viewmodel.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainVM(viewModel: MainViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun bindFeedVM(viewModel: FeedViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BookmarksViewModel::class)
    abstract fun bindBookmarksVM(viewModel: BookmarksViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsVM(viewModel: SettingsViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsVM(viewModel: DetailsViewModel): BaseViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: BaseViewModelFactory): ViewModelProvider.Factory
}