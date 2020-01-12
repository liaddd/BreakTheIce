package com.example.breaktheice.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.breaktheice.R


abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

    fun changeFragment(fragment : Fragment, addToStack : Boolean){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (addToStack){
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.replace(R.id.main_activity_frame_layout, fragment)
        fragmentTransaction.commit()
    }

    fun changeActivity(activity: Activity, destActivity : Class<*>, closeCurrent: Boolean){
        val intent = Intent(activity, destActivity)
        startActivity(intent)
        if (closeCurrent) activity.finish()
    }
}