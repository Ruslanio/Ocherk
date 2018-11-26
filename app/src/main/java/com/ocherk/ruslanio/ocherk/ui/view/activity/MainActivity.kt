package com.ocherk.ruslanio.ocherk.ui.view.activity

import android.os.Bundle
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.databinding.ActivityMainBinding
import com.ocherk.ruslanio.ocherk.mvvm.BaseActivity
import com.ocherk.ruslanio.ocherk.viewmodel.MainViewModel
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onInit(savedInstanceState: Bundle?) {
        binding.viewmodel = viewModel
        viewModel.openDefaultScreen()
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getFragmentContainerID(): Int {
        return R.id.container_main
    }
}
