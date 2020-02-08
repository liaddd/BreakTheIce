package com.example.breaktheice.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.breaktheice.R
import com.example.breaktheice.utils.Constants


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun toast(context: Context?, message: String) {
    android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT).show()
}

fun log(activity: Activity, message: String) {
    Log.d(activity.javaClass.simpleName, message)
}

fun <T> Activity.changeActivity(
    currentActivity: Activity,
    destClass: Class<T>,
    extras: Bundle?,
    closeCurrent: Boolean
) {
    val intent = Intent(currentActivity, destClass)
    if (extras != null) {
        intent.putExtra(Constants.CATEGORIES, extras)
    }
    startActivity(intent)
    if (closeCurrent) currentActivity.finish()
}

fun changeFragment(fragmentManager: FragmentManager, fragment: Fragment, bundle: Bundle?, addToStack: Boolean) {
    val fragmentTransaction = fragmentManager.beginTransaction()
    if (addToStack) {
        fragmentTransaction.addToBackStack(null)
    }
    fragment.arguments = bundle
    fragmentTransaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
    fragmentTransaction.replace(R.id.main_activity_frame_layout, fragment)
    fragmentTransaction.commit()
}