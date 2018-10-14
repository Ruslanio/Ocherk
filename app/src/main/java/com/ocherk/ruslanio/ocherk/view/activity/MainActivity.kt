package com.ocherk.ruslanio.ocherk.view.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.mvvm.BaseActivity
import com.ocherk.ruslanio.ocherk.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onInit(savedInstanceState: Bundle?) {
        
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }


}
