package com.ocherk.ruslanio.ocherk.mvvm

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import butterknife.ButterKnife
import com.ocherk.ruslanio.ocherk.R
import com.production.ruslanio.caloriescalculator.mvvm.BaseViewInterface
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

/**
 * Created by Ruslanio on 28.01.2018.
 */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewDataBinding> : AppCompatActivity(), BaseConstants, BaseViewInterface<VM>, HasSupportFragmentInjector {


    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var viewModel: VM
        private set

    var context: Context = this
        private set

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory

    lateinit var binding : VB
    protected var navigator: Navigator? = null



    private val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)


    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        navigator = SupportAppNavigator(this,getFragmentContainerID())
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = assignViewModel(viewModelFactory)
        onInit(savedInstanceState)
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        if (navigator != null)
            navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    private fun assignViewModel(factory: ViewModelProvider.Factory?): VM {
        if (factory == null) {
            return ViewModelProviders.of(this).get(getViewModelClass())
        } else {
            return ViewModelProviders.of(this, factory).get(getViewModelClass())
        }
    }

    fun showToast(message: String?) {
        if (message == null)
            return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes messageId: Int) {
        Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show()
    }

    fun showSnackBar(message: String?) {
        if (message == null)
            return
        Snackbar.make(window.decorView, message, Snackbar.LENGTH_LONG).show()
    }

    fun showSnackBar(@StringRes messageId: Int) {
        Snackbar.make(window.decorView, messageId, Snackbar.LENGTH_LONG).show()
    }


}