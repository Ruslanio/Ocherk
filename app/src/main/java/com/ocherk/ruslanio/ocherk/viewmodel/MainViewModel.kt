package com.ocherk.ruslanio.ocherk.viewmodel

import android.databinding.ObservableField
import android.support.design.widget.BottomNavigationView
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.remote.pojo.NewsList
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.exceptions.InvalidSearchSpecException
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import com.ocherk.ruslanio.ocherk.navigation.ScreenNames
import com.ocherk.ruslanio.ocherk.ui.adapters.NewsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainViewModel @Inject constructor(val router: Router) : BaseViewModel() {

    val listener = BottomNavigationView.OnNavigationItemSelectedListener {
        return@OnNavigationItemSelectedListener when (it.itemId) {
            R.id.nav_feed -> navigate(ScreenNames.SCREEN_FEED)
            R.id.nav_bookmarks -> navigate(ScreenNames.SCREEN_BOOKMARKS)
            R.id.nav_settings -> navigate(ScreenNames.SCREEN_SETTINGS)
            else -> navigate(ScreenNames.SCREEN_FEED)
        }
    }

    private fun navigate(screenName : String) : Boolean{
        router.navigateTo(screenName)
        return true
    }

    fun openDefaultScreen(){
        navigate(ScreenNames.SCREEN_FEED)
    }
}