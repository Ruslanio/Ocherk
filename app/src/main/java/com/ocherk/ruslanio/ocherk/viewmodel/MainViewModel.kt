package com.ocherk.ruslanio.ocherk.viewmodel

import android.databinding.ObservableField
import android.support.design.widget.BottomNavigationView
import com.ocherk.ruslanio.ocherk.R
import com.ocherk.ruslanio.ocherk.data.DataManager
import com.ocherk.ruslanio.ocherk.data.remote.util.SearchSpecification
import com.ocherk.ruslanio.ocherk.exceptions.InvalidSearchSpecException
import com.ocherk.ruslanio.ocherk.mvvm.BaseViewModel
import com.ocherk.ruslanio.ocherk.navigation.ScreenNames
import com.ocherk.ruslanio.ocherk.ui.adapters.NewsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

class MainViewModel @Inject constructor(val router: Router) : BaseViewModel() {

    val listener = BottomNavigationView.OnNavigationItemSelectedListener {
        return@OnNavigationItemSelectedListener when (it.itemId) {
            R.id.nav_feed -> navigate(ScreenNames.FeedScreen())
            R.id.nav_bookmarks -> navigate(ScreenNames.BookmarksScreen())
            R.id.nav_settings -> navigate(ScreenNames.SettingsScreen())
            else -> navigate(ScreenNames.FeedScreen())
        }
    }

    private fun navigate(screen : SupportAppScreen) : Boolean{
        router.navigateTo(screen)
        return true
    }

    fun openDefaultScreen(){
        navigate(ScreenNames.FeedScreen())
    }
}