package com.ocherk.ruslanio.ocherk.di.builders

import android.arch.lifecycle.ViewModelProvider
import com.ocherk.ruslanio.ocherk.di.ViewModelKey
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModelFactory
import com.ocherk.ruslanio.ocherk.viewmodel.MainViewModel
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
    abstract fun bindViewModelFactory(factory: BaseViewModelFactory): ViewModelProvider.Factory
}