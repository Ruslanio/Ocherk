package com.ocherk.ruslanio.ocherk.ui.view.fragment

import android.os.Bundle
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.databinding.FragmentSettingsBinding
import com.ocherk.ruslanio.ocherk.mvvm.BaseFragment
import com.ocherk.ruslanio.ocherk.viewmodel.SettingsViewModel

class SettingsFragment : BaseFragment<SettingsViewModel, FragmentSettingsBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_settings
    }

    override fun onInit(savedInstanceState: Bundle?) {
    }

    override fun getViewModelClass(): Class<SettingsViewModel> {
        return SettingsViewModel::class.java
    }
}