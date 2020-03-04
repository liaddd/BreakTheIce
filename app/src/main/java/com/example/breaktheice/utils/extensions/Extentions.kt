package com.example.breaktheice.utils.extensions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.breaktheice.R


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun toast(context: Context?, message: String) {
    android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT).show()
}

fun changeFragment(fragmentManager: FragmentManager, fragment: Fragment, bundle: Bundle? = null, addToStack: Boolean = false) {
    val fragmentTransaction = fragmentManager.beginTransaction()
    if (addToStack) {
        fragmentTransaction.addToBackStack(null)
    }
    fragment.arguments = bundle
    fragmentTransaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
    fragmentTransaction.replace(R.id.main_activity_frame_layout, fragment)
    fragmentTransaction.commit()
}

fun <T> MutableList<T>.clearAndAddAll(newData : List<T>){
    clear()
    addAll(newData)
}