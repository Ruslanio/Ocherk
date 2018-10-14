package com.ocherk.ruslanio.ocherk.mvvm


import android.app.Activity
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import com.production.ruslanio.caloriescalculator.mvvm.BaseViewInterface
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * Created by Ruslanio on 19.02.2018.
 */
abstract class BaseFragment<VM : BaseViewModel> : Fragment(), BaseViewInterface<VM> {
    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory

    //set this to define fragment title in ViewPager with tabs
    var title: String? = "title"

    fun setTitle(@StringRes titleId: Int){
        title = activity?.resources?.getString(titleId)
    }

    protected lateinit var viewModel: VM
        private set

    //Check this with isAdded()
    protected var activityContext: Context? = activity


    private val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
        AndroidSupportInjection.inject(this)
        viewModel = assignViewModel(viewModelFactory)
        onInit(savedInstanceState)
    }


    private fun assignViewModel(factory: ViewModelProvider.Factory?): VM {
        if (factory == null) {
            return ViewModelProviders.of(this).get(getViewModelClass())
        } else {
            return ViewModelProviders.of(this, factory).get(getViewModelClass())
        }
    }


    fun BaseFragment<VM>.showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun BaseFragment<VM>.showToast(@StringRes messageId: Int) {
        Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show()
    }

    fun BaseFragment<VM>.showSnackBar(message: String) {
        if (isAdded)
            Snackbar.make((activityContext as Activity).window.decorView, message, Snackbar.LENGTH_LONG).show()
    }

    fun BaseFragment<VM>.showSnackBar(@StringRes messageId: Int) {
        if (isAdded)
            Snackbar.make((activityContext as Activity).window.decorView, messageId, Snackbar.LENGTH_LONG).show()
    }

}