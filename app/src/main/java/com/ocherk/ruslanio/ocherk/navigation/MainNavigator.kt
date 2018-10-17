package com.ocherk.ruslanio.ocherk.navigation

import android.app.Activity
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Toast
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import com.ocherk.ruslanio.ocherk.navigation.ScreenNames.Companion.SCREEN_BOOKMARKS
import com.ocherk.ruslanio.ocherk.navigation.ScreenNames.Companion.SCREEN_FEED
import com.ocherk.ruslanio.ocherk.navigation.ScreenNames.Companion.SCREEN_SETTINGS
import com.ocherk.ruslanio.ocherk.ui.view.fragment.BookmarksFragment
import com.ocherk.ruslanio.ocherk.ui.view.fragment.FeedFragment
import com.ocherk.ruslanio.ocherk.ui.view.fragment.SettingsFragment

class MainNavigator(private val activity: Activity, @IdRes private var containerId: Int,
                    fragmentManager: FragmentManager) : SupportFragmentNavigator(fragmentManager, containerId) {

    override fun createFragment(screenKey: String?, data: Any?): Fragment = when (screenKey) {
        SCREEN_FEED -> FeedFragment()
        SCREEN_BOOKMARKS -> BookmarksFragment()
        SCREEN_SETTINGS -> SettingsFragment()
        else -> FeedFragment()
    }

    override fun exit() {
        activity.finish()
    }

    override fun showSystemMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}