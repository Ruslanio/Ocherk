package com.ocherk.ruslanio.ocherk.util

import android.databinding.BindingAdapter
import android.databinding.BindingMethod
import android.support.design.widget.BottomNavigationView
import android.widget.ImageView
import android.widget.PopupMenu
import com.bumptech.glide.Glide
import com.ocherk.ruslanio.ocherk.R


@BindingAdapter("imageurl")
fun ImageView.loadImage(url: String?) {
    if (url != null) {
        Glide.with(context).load(url).into(this)
    } else {
        Glide.with(context).load(R.drawable.blank).into(this)
    }
}

@BindingAdapter("onItemClick")
fun BottomNavigationView.setOnItemClickListener(listener: BottomNavigationView.OnNavigationItemSelectedListener){
    this.setOnNavigationItemSelectedListener(listener)
}
