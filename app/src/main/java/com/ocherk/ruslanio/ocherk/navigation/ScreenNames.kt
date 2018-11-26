package com.ocherk.ruslanio.ocherk.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.ocherk.ruslanio.ocherk.ui.view.activity.DetailsActivity
import com.ocherk.ruslanio.ocherk.ui.view.activity.MainActivity
import com.ocherk.ruslanio.ocherk.ui.view.fragment.BookmarksFragment
import com.ocherk.ruslanio.ocherk.ui.view.fragment.FeedFragment
import com.ocherk.ruslanio.ocherk.ui.view.fragment.SettingsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ScreenNames {
    companion object {

        const val SCREEN_MAIN = "screen_main"
        const val SCREEN_FEED = "screen_feed"
        const val SCREEN_BOOKMARKS = "screen_bookmarks"
        const val SCREEN_SETTINGS = "screen_settings"

    }

    class MainScreen : SupportAppScreen(){
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }


    class BookmarksScreen : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return BookmarksFragment()
        }
    }


    class FeedScreen : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return FeedFragment()
        }
    }

    class SettingsScreen : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return SettingsFragment()
        }
    }

    class DetailsScreen : SupportAppScreen(){
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, DetailsActivity::class.java)
        }
    }
}