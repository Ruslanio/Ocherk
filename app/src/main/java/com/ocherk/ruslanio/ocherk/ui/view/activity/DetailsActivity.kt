package com.ocherk.ruslanio.ocherk.ui.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.databinding.ActivityDetailsBinding
import com.ocherk.ruslanio.ocherk.mvvm.BaseActivity
import com.ocherk.ruslanio.ocherk.viewmodel.DetailsViewModel

class DetailsActivity : BaseActivity<DetailsViewModel, ActivityDetailsBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_details
    }

    override fun onInit(savedInstanceState: Bundle?) {
        binding.viewmodel = viewModel
    }

    override fun getViewModelClass(): Class<DetailsViewModel> {
        return DetailsViewModel::class.java
    }

}
