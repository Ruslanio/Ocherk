package com.ocherk.ruslanio.ocherk.ui.view.fragment

import android.os.Bundle
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.databinding.FragmentBookmarksBinding
import com.ocherk.ruslanio.ocherk.mvvm.BaseFragment
import com.ocherk.ruslanio.ocherk.viewmodel.BookmarksViewModel

class  BookmarksFragment :BaseFragment<BookmarksViewModel,FragmentBookmarksBinding>(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_bookmarks
    }

    override fun onInit(savedInstanceState: Bundle?) {
    }

    override fun getViewModelClass(): Class<BookmarksViewModel> {
        return BookmarksViewModel::class.java
    }
}