package com.ocherk.ruslanio.ocherk.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ruslanio on 07.03.2018.
 */
class BaseViewModelFactory
@Inject constructor(private val viewModels : Map<Class<out BaseViewModel>,@JvmSuppressWildcards Provider<BaseViewModel>>)
    : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val provider : Provider<BaseViewModel> = viewModels[modelClass as Class<out BaseViewModel>]
                ?: throw IllegalArgumentException("Unknown viewmodel class : " + modelClass.name)
        return provider.get() as T
    }
}