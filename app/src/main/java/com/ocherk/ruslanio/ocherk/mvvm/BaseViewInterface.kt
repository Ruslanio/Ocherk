package com.production.ruslanio.caloriescalculator.mvvm

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel

/**
 * Created by Ruslanio on 19.02.2018.
 */
interface BaseViewInterface<VM : BaseViewModel> {

    @LayoutRes
    fun getLayoutId(): Int

    fun onInit(savedInstanceState: Bundle?)
    fun getViewModelClass(): Class<VM>

    fun String.toIntWithCare() : Int?{
        val spaceRegex = Regex(".*\\s+.*")
        if (this.equals("") || this.matches(spaceRegex))
            return null
        else
            return this.toInt()
    }
}