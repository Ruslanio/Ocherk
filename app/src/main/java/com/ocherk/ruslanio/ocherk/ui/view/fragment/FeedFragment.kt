package com.ocherk.ruslanio.ocherk.ui.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.databinding.FragmentFeedBinding
import com.ocherk.ruslanio.ocherk.mvvm.BaseFragment
import com.ocherk.ruslanio.ocherk.viewmodel.FeedViewModel

class FeedFragment : BaseFragment<FeedViewModel,FragmentFeedBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_feed
    }

    override fun onInit(savedInstanceState: Bundle?) {
        binding.viewmodel = viewModel
        viewModel.getNews(false)
    }

    override fun getViewModelClass(): Class<FeedViewModel> {
        return FeedViewModel::class.java
    }

}