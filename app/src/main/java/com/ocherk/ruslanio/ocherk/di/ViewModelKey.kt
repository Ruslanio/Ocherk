package com.ocherk.ruslanio.ocherk.di

import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import dagger.MapKey

import kotlin.reflect.KClass

/**
 * Created by Ruslanio on 07.03.2018.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out BaseViewModel>)